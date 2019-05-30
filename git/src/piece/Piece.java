package piece;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.Board;
import game.Tile;

public abstract class Piece
{
	//Maximum movement range of a piece
	protected final static int MAX_RANGE = 2;
	
	//The tile the piece is on
	protected Tile tile;
	//Whether the piece is alive (true) or not (false)
	private Boolean status;
	//Which side the piece belongs to
	protected Boolean isWhite;

	//Constructor
	public Piece(Tile tile, Boolean isWhite)
	{
		this.status = true;
		this.tile = tile;
		this.isWhite = isWhite;
		tile.setPiece(this);
	}
	
	//Getters and Setters
	public Boolean getIsWhite()
	{
		return isWhite;
	}

	public Tile getTile()
	{
		return tile;
	}

	public Boolean getStatus()
	{
		return status;
	}

	public void setStatus(boolean stat)
	{
		status = stat;
	}

	//Move the piece to the tile provided
	public void moveTo(Tile tile)
	{
		this.tile.setPiece(null);
		this.tile = tile;
		tile.setPiece(this);
	}
	
	//Check if the two piece are equal
	public boolean equals(Piece piece)
	{
		//Boolean to hold if they are or not
		boolean isEqual = false;
		//Check the variables of the piece
		if(this.tile.getXPosition() == piece.tile.getXPosition())
		{
			if(this.tile.getYPosition() == piece.tile.getYPosition())
			{
				if(this.isWhite == piece.getIsWhite())
				{
					isEqual = true;
				}
			}
		}
		return isEqual;
	}
	
	//Method to get all of the moves the piece can perform
	public abstract ArrayList<Tile> allMovements(Board board);

	//Method to display the piece
	public abstract ImageIcon display();
}
