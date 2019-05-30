package game;
import piece.Piece;

public class Player
{
	//Array of the pieces owned by the player
	private Piece[] pieces;
	//Score of the player
	private int score;
	//Which side the player is on
	private boolean side;
	
	//Constructor
	public Player(Piece[] pieces, boolean side)
	{
		//Instantiate player
		this.pieces = pieces;
		this.side = side;
		this.score = 0;
	}
	
	//Getters
	public Piece getPiece(int i)
	{
		return pieces[i];
	}
	
	public Piece[] getPieces()
	{
		return pieces;
	}
	
	public boolean getSide()
	{
		return side;
	}
	
	public int getScore()
	{
		return score;
	}
	
	//Increment the players score by 1
	public void incrementScore()
	{
		score++;
	}
	
	//Check if the player is still alive
	public boolean isInGame()
	{
		//Counter of how many of the player's pieces are alive
		int piecesAlive = 0;
		//Check each piece to see if it is still alive
		for(int i = 0; i < pieces.length; i++)
		{
			//If the piece is alive
			if(pieces[i].getStatus())
			{
				piecesAlive++;
			}
		}
		//If the player has no pieces left
		if(piecesAlive > 0)
		{
			return true;
		}
		return false;
	}
}
