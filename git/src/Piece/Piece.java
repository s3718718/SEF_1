package Piece;
import java.util.ArrayList;

import Game.Board;
import Game.Tile;
import Game.Position;

public abstract class Piece
{
	protected Tile tile;
	private Boolean status;
	protected Boolean isWhite;
	protected Board board;

	public Piece(Tile tile, Boolean isWhite, Board board)
	{
		this.status = true;
		this.tile = tile;
		this.isWhite = isWhite;
		tile.setPiece(this);
		this.board = board;
	}
	
	public Boolean getIsWhite()
	{
		return isWhite;
	}

	public Boolean getStatus()
	{
		return status;
	}

	public void setStatus(boolean stat)
	{
		status = stat;
	}

	public Tile getTile()
	{
		return tile;
	}

	public void moveTo(Tile tile)
	{
		this.tile.setPiece(null);
		this.tile = tile;
		tile.setPiece(this);
	}

	public abstract boolean canMove(Board board, Position position);
	
	public abstract ArrayList<Tile> allMovements();

	public abstract void display();
}
