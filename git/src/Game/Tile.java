package Game;
import Piece.*;

public class Tile {
	private Piece piece;
	private Position position;

	public Tile(Position position) {
		this.position = position;
	}

	public Position getPosition(){
		return position;
	}

	public boolean isPieceHere(){
		if (piece == null){
			return false;
		}
		else {
			return true;
		}
	}

	public Piece getPiece(){
		return piece;
	}

	public void setPiece(Piece piece){
		this.piece = piece;
	}

	public void display(){
		if (piece == null)
			System.out.print(" ");
		else piece.display();
	}
}
