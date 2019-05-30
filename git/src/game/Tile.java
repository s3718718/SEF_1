package game;
import piece.*;

public class Tile 
{
	//The piece currently on the tile
	private Piece piece;
	//The x position and the y position
	private int xPosition;
	private int yPosition;

	//Constructor
	public Tile(int xPosition, int yPosition)
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	//Getters and Setters
	public int getXPosition()
	{
		return xPosition;
	}
	
	public int getYPosition()
	{
		return yPosition;
	}	
	
	public Piece getPiece()
	{
		return piece;
	}

	public void setPiece(Piece piece)
	{
		this.piece = piece;
	}

	//Method to check if a piece is on the tile
	public boolean isPieceHere()
	{
		//Return false if there is no piece
		boolean pieceHere = false;
		if (piece != null)
		{
			//Piece exists so return true
			pieceHere = true;
		}
		return pieceHere;
	}
}
