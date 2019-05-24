package Piece;
import java.util.ArrayList;

import Game.*;

public class Rook extends Piece
{
	public Rook(Tile tile, Boolean isWhite, Board board)
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
				int absDispX = Math.abs(origX - targetX);
				int absDispY = Math.abs(origY - targetY);
				if(absDispX <= 2 && absDispY <= 2)
				{
					if(targetX == origX && targetY != origY ||
							targetX != origX && targetY == origY)
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
				int origX = tile.getPosition().getX();
				int origY = tile.getPosition().getY();
				int targetX = origX + i;
				int targetY = origY + j;
				if(targetX < 6 && targetX >= 0)
				{
					if(targetY < 6 && targetY >= 0)
					{
						if(targetX == origX && targetY != origY ||
								targetX != origX && targetY == origY)
						{
							boolean checkTile = false;
							Tile targetTile = board.tiles[targetX][targetY];
							if(Math.abs(i) == 2)
							{
								Tile middleTile = board.tiles
										[origX+(i/2)][targetY];
								if(!middleTile.isPieceHere())
								{
									if(!targetTile.isPieceHere())
									{
										checkTile = true;
									}else
									{
										if(targetTile.getPiece().getIsWhite() 
												!= this.isWhite)
										{
											checkTile = true;
										}
									}	
								}
							}else if(Math.abs(j) == 2)
							{
								Tile middleTile = board.tiles
										[targetX][origY+(j/2)];
								if(!middleTile.isPieceHere())
								{
									if(!targetTile.isPieceHere())
									{
										checkTile = true;
									}else
									{
										if(targetTile.getPiece().getIsWhite() 
												!= this.isWhite)
										{
											checkTile = true;
										}
									}	
								}
							}else
							{
								if(!targetTile.isPieceHere())
								{
									checkTile = true;
								}else
								{
									if(targetTile.getPiece().getIsWhite() != this.isWhite)
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
	public void display()
	{
		if (isWhite == true)
		{
			System.out.print("R");
		}
		else
		{
			System.out.print("r");
		}
	}
}
