package Game;
import java.util.Scanner;

import Piece.Bishop;
import Piece.Knight;
import Piece.Piece;
import Piece.Rook;


public class Game {
	public Board board;
	Board lastTurnBoard;
	int turns;
	int currentTurn;
	Player player1;
	Player player2;
	public Piece[] side1;
	public Piece[] side2;

	public Game(int turns) {
		this.turns = turns;
		board = new Board();
		instantiatePiece();
		player1 = new Player(side1, true);
		player2 = new Player(side2, false);
		currentTurn = 1;
	}
	//Flow of the game
	public void play(){
		boolean inGame = true;
		while (inGame == true){
			System.out.println();
			System.out.println("****The 'Chess Game'****");
			System.out.println("Turn "+currentTurn+"/"+turns);
			System.out.println("Score: Player1 ("+player1.getScore()+
					") vs Player2 ("+player2.getScore()+")");
			if ((currentTurn%2)==1){
				System.out.println("****Player 1 turn****");
				playerTurn(player1);
			}
			else if ((currentTurn%2)==0){
				System.out.println("****Player 2 turn****");
				playerTurn(player2);
			}
			if (currentTurn > turns){
				inGame = false;
			}
			if (player1.isInGame() == false || player2.isInGame() == false){
				inGame = false;
			}
		}
		System.out.println("Game done");
	}

	public void playerTurn(Player player){
		int step = 1;
		boolean check = false;
		Scanner sc = new Scanner(System.in);
		Validate test = new Validate();
		int pieceToMove=0;
		int x=0;
		int y=0;
		while (check == false){
			board.display();
			System.out.println();
			if (step == 1){
				int i =0;
				for (;i < player.getPieces().length; i++){
					Piece piece = player.getPiece(i);
					if (piece.getStatus() == true){
						System.out.print(i+1+", " +piece.toString()+ "["+piece.getTile().getPosition().getX()
								+","+piece.getTile().getPosition().getY()+"]  ");
					}
				}
				System.out.println();
				System.out.println("****Enter Piece to move****");
				String input = sc.nextLine();
				pieceToMove = test.isPositiveInt(input);
				if (pieceToMove==-1){
					continue;
				}
				else if (pieceToMove > i) {
					continue;
				}
				else{
					step=2;
				}
			}
			else if (step == 2){
				System.out.println("****Choose destination(x/y)****");
				System.out.println("****Enter x: ");
				String input = sc.nextLine();
				x = test.isPositiveInt(input);
				if (x > 5 || x < 0){
					continue;
				}
				else {
					System.out.println("****Enter y: ");
					input = sc.nextLine();
					y = test.isPositiveInt(input);
					if (y>5 || y<0){
						continue;
					}
					else {
						step=3;
					}
				}
			}
			else if (step == 3){
				boolean checkMove = tryMove(player.getPiece(pieceToMove-1),board.tiles[x][y]);
				if (checkMove == true) {
					System.out.println("****Move Successful****");
					check = true;
				}
				else {
					System.out.println("****Move Unsuccessful****");
					step = 1;
				}
			}
		}
		nextTurn();
	}

	private void instantiatePiece(){
		side1 = new Piece[6];
		side2 = new Piece[6];
		side1[0] = new Rook(board.tiles[0][0], true);
		side1[1] = new Bishop(board.tiles[0][1], true);
		side1[2] = new Knight(board.tiles[0][2], true);
		side1[3] = new Rook(board.tiles[0][3], true);
		side1[4] = new Bishop(board.tiles[0][4], true);
		side1[5] = new Knight(board.tiles[0][5], true);
		side2[0] = new Rook(board.tiles[5][0], false);
		side2[1] = new Bishop(board.tiles[5][1], false);
		side2[2] = new Knight(board.tiles[5][2], false);
		side2[3] = new Rook(board.tiles[5][3], false);
		side2[4] = new Bishop(board.tiles[5][4], false);
		side2[5] = new Knight(board.tiles[5][5], false);
	}

	private void movePiece(Piece piece, Tile tile){
		piece.moveTo(tile);
		tile.setPiece(piece);
	}

	public boolean tryMove(Piece piece, Tile tile){
		boolean check = piece.canMoveHere(board, tile.getPosition());
		//Check board is there is any piece at this position
		if (check == true){
			check = tile.isPieceHere();
			if (check == true){
				boolean desSide = tile.getPiece().getIsSide1();
				boolean thisPiece = piece.getIsSide1();
				if (desSide == thisPiece) {
					System.out.println("****Destination piece is same side");
					return false;
				}
				else {
					tile.getPiece().setStatus(false);
					tile.setPiece(null);
					if (piece.getIsSide1() == true)
						player1.setScore(player1.getScore()+1);
					else player2.setScore(player2.getScore()+1);
					movePiece(piece,tile);
				}
			}
			else {
				movePiece(piece,tile);
			}
		}
		else {
			System.out.println("****This piece can not move to here");
			return false;
		}
		return true;
	}

	private void nextTurn(){
		currentTurn++;
	}

}
