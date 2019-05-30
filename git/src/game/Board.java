package game;

public class Board
{
	//Array to hold all of the tiles in
	public Tile[][] tiles;

	public Board()
	{
		//Instantiate tiles
		tiles = new Tile[Game.SIZE][Game.SIZE];
		for (int xPosition = 0; xPosition < Game.SIZE; xPosition++)
		{
			for (int yPosition = 0; yPosition < Game.SIZE; yPosition++)
			{
				tiles[xPosition][yPosition] = new Tile(xPosition, yPosition);
			}
		}
	}
	
	//Getters and Setters
	public Tile[][] getBoard()
	{
		return tiles;
	}

	public Tile getTile(int xPosition, int yPosition)
	{
		return tiles[xPosition][yPosition];
	}
}
