package piece;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.*;

public class Knight extends Piece
{
	//Constructor
	public Knight(Tile tile, Boolean isWhite)
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
				//Check the movement pattern
				if(Math.abs(i) == 1 && Math.abs(j) == 2 ||
						Math.abs(i) == 2 && Math.abs(j) == 1)
				{
					int targetX = i + tile.getXPosition();
					int targetY = j + tile.getYPosition();
					//Check the move is on the board
					if(targetX < Game.SIZE && targetX >= 0)
					{
						if(targetY < Game.SIZE && targetY >= 0)
						{
							//Check if the tile for a piece
							Tile targetTile = board.getTile(targetX, targetY);
							if(!targetTile.isPieceHere())
							{
								moveList.add(targetTile);
							}else
							{
								//Check if the piece on the tile can be taken
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
	//Method to display the piece
	public ImageIcon display()
	{
		//Image of the piece
		ImageIcon knight = null;
		//Check which side the piece is and get the correct image
		if (isWhite == true)
		{
			knight = new ImageIcon("resources/white-knight.png");
		}
		else
		{
			knight = new ImageIcon("resources/black-knight.png");
		}
		return knight;
	}
}
