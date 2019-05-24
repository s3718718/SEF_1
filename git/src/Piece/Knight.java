package Piece;

import java.util.ArrayList;
import Game.*;

public class Knight extends Piece
{
	public Knight(Tile tile, Boolean isWhite, Board board)
	{
		super(tile, isWhite, board);
	}

	@Override
	public boolean canMove(Board board, Position position)
	{
		boolean moveAllowed = false;
		int targetX = position.getX();
		int targetY = position.getY();
		if(targetX < 6 && targetX >= 0)
		{
			if(targetY < 6 && targetY >= 0)
			{
				int origX = tile.getPosition().getX();
				int origY = tile.getPosition().getY();
				int dispX = origX - targetX;
				int dispY = origY - targetY;
				if(Math.abs(dispX) == 1 && Math.abs(dispY) == 2 ||
						Math.abs(dispX) == 2 && Math.abs(dispY) == 1)
				{
					moveAllowed = true;
				}
			}
		}
		return moveAllowed;
	}
	
	@Override
	public ArrayList<Tile> allMovements()
	{
		ArrayList<Tile> moveList = new ArrayList<Tile>();
		for(int i = -2; i < 3; i++)
		{
			for(int j = -2; j < 3; j++)
			{
				if(Math.abs(i) == 1 && Math.abs(j) == 2 ||
						Math.abs(i) == 2 && Math.abs(i) == 1)
				{
					int targetX = i + tile.getPosition().getX();
					int targetY = j + tile.getPosition().getY();
					if(targetX < 6 && targetX >= 0)
					{
						if(targetY < 6 && targetY >= 0)
						{
							Tile targetTile = board.tiles[targetX][targetY];
							if(!targetTile.isPieceHere())
							{
								moveList.add(targetTile);
							}else
							{
								if(targetTile.getPiece().getIsWhite() != this.isWhite)
								{
									moveList.add(targetTile);
								}
							}
						}
					}
				}
			}
		}
		return moveList;
	}

	@Override
	public void display()
	{
		if (isWhite == true)
		{
			System.out.print("K");
		}
		else
		{
			System.out.print("k");
		}
	}
}
