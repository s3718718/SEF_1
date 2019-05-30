package game;

import java.util.ArrayList;

import piece.Bishop;
import piece.Knight;
import piece.Piece;
import piece.Rook;
import view.GameDialog;
import view.ChessGui;


public class Game 
{
	//Size of the board and the number of pieces on each side
	public final static int SIZE = 6;
	//Holds the board of the game
	private Board board;
	//The maximum amount of turns the game can have
	private int turns;
	//The current number of turns
	private int currentTurn;
	//Player 1 or the player on the white side
	private Player player1;
	//Player 2 or the player on the black side
	private Player player2;
	//An array of pieces owned by the white player
	private Piece[] whiteSide;
	//Array of pieces owned by the black player
	private Piece[] blackSide;
	//The GUI of the entire
	private ChessGui gui;
	//Keep the currently selected piece
	private Piece selected;
	//Keeps all possible moves the selected piece can make
	private ArrayList<Tile> possibleMoves;
	//Keeps track of which players turn it is
	//White Side / Player 1 = true
	//Black Side / Player 2 = false
	boolean currentPlayer;

	//Constructor
	public Game(int turns)
	{
		//Set up the basic info of the game
		this.turns = turns;
		board = new Board();
		whiteSide = new Piece[SIZE];
		blackSide = new Piece[SIZE];
		instantiatePiece();
		player1 = new Player(whiteSide, true);
		player2 = new Player(blackSide, false);
		currentTurn = 1;
		selected = null;
		possibleMoves = new ArrayList<Tile>();
		currentPlayer = true;
	}
	
	//Getters
	public Player getPlayer1()
	{
		return player1;
	}
	
	public Player getPlayer2()
	{
		return player2;
	}
	
	public int getTurns()
	{
		return turns;
	}
	
	public int getCurrentTurn()
	{
		return currentTurn;
	}
	
	public boolean getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public ChessGui getGUI()
	{
		return gui;
	}
	
	//Methods
	//Method to start the game
	public void runGame()
	{
		gui = new ChessGui(SIZE, SIZE, this);
	}

	//Method to create the pieces
	private void instantiatePiece()
	{
		//Instantiate Pieces to a Side
		whiteSide[0] = new Rook(board.tiles[0][0], true);
		whiteSide[1] = new Bishop(board.tiles[0][1], true);
		whiteSide[2] = new Knight(board.tiles[0][2], true);
		
		whiteSide[3] = new Knight(board.tiles[0][3], true);
		whiteSide[4] = new Bishop(board.tiles[0][4], true);
		whiteSide[5] = new Rook(board.tiles[0][5], true);
		
		blackSide[0] = new Rook(board.tiles[5][0], false);
		blackSide[1] = new Bishop(board.tiles[5][1], false);
		blackSide[2] = new Knight(board.tiles[5][2], false);
	
		blackSide[3] = new Knight(board.tiles[5][3], false);
		blackSide[4] = new Bishop(board.tiles[5][4], false);
		blackSide[5] = new Rook(board.tiles[5][5], false);
	}
	
	//Method to take a piece
	private void takePiece(Tile tile, Piece piece)
	{
		tile.getPiece().setStatus(false);
		tile.setPiece(null);
		if (piece.getIsWhite() == true)
		{
			player2.incrementScore();
		}else
		{
			player1.incrementScore();
		}
	}

	//Method to put the next turn in motion
	private void nextTurn()
	{
		//Update turn information
		currentTurn++;
		selected = null;
		gui.getBoardPanel().clearHighlightMoves(possibleMoves);
		possibleMoves.clear();
		gui.getInfoPanel().updateScore(player1.getScore(), player2.getScore());
		if(currentPlayer)
		{
			currentPlayer = false;
		}else
		{
			currentPlayer = true;
		}
		//Check if the game is over
		if (player1.isInGame() == false || player2.isInGame() == false ||
				currentTurn > turns)
		{
			new GameDialog(this);
		}else
		{
			gui.getInfoPanel().updateTurn(turns, currentTurn);
		}
	}

	//Select a Piece or Move the selected Piece
	public void selectOrMovePiece(int xPosition, int yPosition)
	{
		//Get the targeted tile
		Tile targetTile = board.getTile(yPosition, xPosition);
		//Boolean to see if a new piece is selected
		boolean newPieceSelected = false;
		if(selected != null)
		{
			//Null Check to see if there is a piece there
			if(targetTile.isPieceHere())
			{
				//Check if the piece is owned by the current player
				Piece targetPiece = targetTile.getPiece();
				if(targetPiece.getIsWhite() == selected.getIsWhite())
				{
					selected = targetPiece;
					newPieceSelected = true;
				}else
				{
					//See if the move is legal
					if(tryMove(targetTile))
					{
						nextTurn();
					}
				}
			}else
			{
				//See if the move is legal
				if(tryMove(targetTile))
				{
					nextTurn();
				}
			}
		}else
		{
			//Null Check to see if there is a piece there
			if(targetTile.isPieceHere())
			{
				//Check if the piece is owned by the current player
				Piece targetPiece = targetTile.getPiece();
				if(targetPiece.getIsWhite() == currentPlayer)
				{
					selected = targetPiece;
					newPieceSelected = true;
				}
			}
		}
		//If a new piece was selected
		if(newPieceSelected)
		{
			//Update the GUI and clear possible moves
			gui.getBoardPanel().clearHighlightMoves(possibleMoves);
			possibleMoves.clear();
			possibleMoves = selected.allMovements(board);
			gui.getBoardPanel().highlightMoves(possibleMoves);
		}
	}
	
	public boolean tryMove(Tile targetTile)
	{
		//Boolean to see if the piece was moved
		boolean pieceMoved = false;
		//Null check to ensure there are possible moves
		if(!possibleMoves.isEmpty())
		{
			//Check the move list to see if it is possible or not
			if(possibleMoves.contains(targetTile))
			{
				//Check to see if a piece is taken by the move
				if(targetTile.isPieceHere())
				{
					takePiece(targetTile, targetTile.getPiece());
					pieceMoved = true;
				}else
				{
					pieceMoved = true;
				}
			}
		}
		//If the piece move was legal
		if(pieceMoved)
		{
			//Update the GUI and move the piece itself
			gui.getBoardPanel().pieceMove(selected, targetTile);
			selected.moveTo(targetTile);
		}
		return pieceMoved;
	}
}
