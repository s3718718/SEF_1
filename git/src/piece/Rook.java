package piece;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.*;

public class Rook extends Piece
{
	//Constructor
	public Rook(Tile tile, Boolean isWhite)
	{
		super(tile, isWhite);
	}
	
	@Override
	//Method to get all of the moves the piece can perform
	public ArrayList<Tile> allMovements(Board board)
	{
		//Array to hold the legal moves
		ArrayList<Tile> moveList = new ArrayList<Tile>();
		//Check for all moves in the movement radius
		for(int i = -MAX_RANGE; i <= MAX_RANGE; i++)
		{
			for(int j = -MAX_RANGE; j <= MAX_RANGE; j++)
			{
				//Get some positions
				int origX = tile.getXPosition();
				int origY = tile.getYPosition();
				int targetX = origX + i;
				int targetY = origY + j;
				//Check the move is on the board
				if(targetX < Game.SIZE && targetX >= 0)
				{
					if(targetY < Game.SIZE && targetY >= 0)
					{
						//Check the movement pattern
						if(targetX == origX && targetY != origY ||
								targetX != origX && targetY == origY)
						{
							//Boolean to hold if the move is allowed or not
							boolean checkTile = false;
							//Boolean to check if there is a piece blocking the way
							boolean checkBlockes = false;
							Tile targetTile = board.getTile(targetX, targetY);
							//Check if the movement was more than 1
							if(Math.abs(i) == MAX_RANGE)
							{
								//Check if there is a piece blocking the movement
								Tile middleTile = board.getTile
										(origX+(i/2), targetY);
								if(!middleTile.isPieceHere())
								{
									//No Pieces blocking the way
									checkBlockes = true;	
								}
							}else if(Math.abs(j) == 2)
							{
								//Check if there is a piece blocking the movement
								Tile middleTile = board.getTile
										(targetX, origY+(j/2));
								if(!middleTile.isPieceHere())
								{
									//No Pieces blocking the way
									checkBlockes = true;
								}
							}else
							{
								//No Pieces blocking the way
								checkBlockes = true;
							}
							if(checkBlockes)
							{
								//Check if the target tile is clear
								if(!targetTile.isPieceHere())
								{
									checkTile = true;
								}else
								{
									//Check if the piece on the 
									//	target can be taken
									if(targetTile.getPiece().getIsWhite() 
											!= this.isWhite)
									{
										checkTile = true;
									}
								}
							}
							//Check if the move is legal
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
	//Method to display the piece
	public ImageIcon display()
	{
		//Image of the piece
		ImageIcon rook = null;
		//Check which side the piece is on and get te correct image
		if (isWhite == true)
		{
			rook = new ImageIcon("resources/white-rook.png");
		}
		else
		{
			rook = new ImageIcon("resources/black-rook.png");
		}
		return rook;
	}
}
