package piece;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.*;

public class Bishop extends Piece
{
	//Constructor
	public Bishop(Tile tile, Boolean isWhite)
	{
		super(tile, isWhite);
	}
	
	@Override
	//Method to get all of the moves the piece can perform
	public ArrayList<Tile> allMovements(Board board)
	{
		//Array of allowed moves
		ArrayList<Tile> moveList = new ArrayList<Tile>();
		//Check all moves in the move radius
		for(int i = -MAX_RANGE; i <= MAX_RANGE; i++)
		{
			for(int j = -MAX_RANGE; j <= MAX_RANGE; j++)
			{
				//Check for match in movement pattern
				if(Math.abs(i) == Math.abs(j))
				{
					int targetX = i + tile.getXPosition();
					int targetY = j + tile.getYPosition();
					//Check the target position is on the board
					if(targetX < Game.SIZE && targetX >= 0)
					{
						if(targetY < Game.SIZE && targetY >= 0)
						{
							//Boolean to see if the tile is legal
							boolean checkTile = false;
							Tile targetTile = board.getTile(targetX, targetY);
							int origX = tile.getXPosition();
							int origY = tile.getYPosition();
							//Check for pieces already on the tile
							if(!targetTile.isPieceHere())
							{
								//Check if the movement is more then one space away
								if(Math.abs(i) == MAX_RANGE || 
										Math.abs(j) == MAX_RANGE)
								{
									//Check if the tile inbetween is not blocked
									Tile middleTile = board.getTile(origX+(i/2), 
											origY+(j/2));
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
								//Check if the piece can be taken
								if(targetTile.getPiece().getIsWhite() != this.isWhite)
								{
									//Check if the movement is more then one space away
									if(Math.abs(i) == MAX_RANGE || 
											Math.abs(j) == MAX_RANGE)
									{
										//Check if the tile inbetween is not blocked
										Tile middleTile = board.getTile(origX+(i/2), 
												origY+(i/2));
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
							//If the move is legal add it to the list
							if(checkTile == true)
							{
								moveList.add(targetTile);
							}
						}
					}
				}
			}
		}
		//return the list of allowed moves
		return moveList;
	}

	@Override
	//Method to display a piece
	public ImageIcon display()
	{
		//Image of the piece
		ImageIcon bishop = null;
		//Check which side the piece is and get correct image
		if (isWhite == true)
		{
			bishop = new ImageIcon("resources/white-bishop.png");
		}
		else
		{
			bishop = new ImageIcon("resources/black-bishop.png");
		}
		return bishop;
	}
}
