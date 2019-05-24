package Piece;
import java.util.ArrayList;

import Game.*;

public class Bishop extends Piece
{
	public Bishop(Tile tile, Boolean isWhite, Board board)
	{
		super(tile, isWhite, board);
	}

	@Override
	public boolean canMove(Board board, Position position)
	{
		boolean moveAllowed = false;
		int targetX = position.getX();
		int targetY = position.getY();
		int origX = tile.getPosition().getX();
		int origY = tile.getPosition().getY();
		if(origX != targetX || origY != targetY)
		{
			if(targetX < 6 && targetX >= 0)
			{
				if(targetY < 6 && targetY >= 0)
				{
					int absDispX = Math.abs(origX - targetX);
					int absDispY = Math.abs(origY - targetY);
					if(absDispX == absDispY && 
							absDispX <= 2 && absDispY <= 2)
					{
						moveAllowed = true;
					}
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
				if(Math.abs(i) == Math.abs(j))
				{
					int targetX = i + tile.getPosition().getX();
					int targetY = j + tile.getPosition().getY();
					if(targetX < 6 && targetX >= 0)
					{
						if(targetY < 6 && targetY >= 0)
						{
							boolean checkTile = false;
							Tile targetTile = board.tiles[targetX][targetY];
							int origX = tile.getPosition().getX();
							int origY = tile.getPosition().getY();
							if(!targetTile.isPieceHere())
							{
								if(Math.abs(i) == 2 || Math.abs(j) == 2)
								{
									Tile middleTile = board.tiles
											[origX+(i/2)][origY+(i/2)];
									if(!middleTile.isPieceHere())
									{
										checkTile = true;
									}
								}else
								{
									checkTile = true;
								}
							}else
							{
								if(targetTile.getPiece().getIsWhite() != this.isWhite)
								{
									if(Math.abs(i) == 2 || Math.abs(j) == 2)
									{
										Tile middleTile = board.tiles
												[origX+(i/2)][origY+(i/2)];
										if(!middleTile.isPieceHere())
										{
											checkTile = true;
										}
									}else
									{
										checkTile = true;
									}
								}
							}
							if(checkTile == true)
							{
								moveList.add(targetTile);
							}
						}
					}
				}
			}
		}
		return moveList;
	}

	@Override
	public
	void display()
	{
		if (isWhite == true)
		{
			System.out.print("B");
		}
		else
		{
			System.out.print("b");
		}
	}
}
