package Game;

public class Board {
	public Tile[][] tiles;

	public Tile[][] getBoard() {
		return tiles;
	}

	public Board(){
		//Instantiate tiles
		tiles = new Tile[6][6];
		for (int x=0; x < 6; x++){
			for (int y=0; y < 6; y++){
				tiles[x][y] = new Tile(new Position(x,y));
			}
		}
	}

	public Tile getTile(Position position){
		return tiles[position.getX()][position.getY()];
	}

	public void display(){
		System.out.print("| |0|1|2|3|4|5|");
		for (int x = 0; x < 6; x++){
			System.out.println();
			System.out.print("|"+x+"|");
			for (int y =0; y < 6; y++){
				tiles[x][y].display();
				System.out.print("|");
			}
		}
		System.out.println();
	}
}
