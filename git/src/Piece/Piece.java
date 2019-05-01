package Piece;
import Game.Board;
import Game.Tile;
import Game.Position;

public abstract class Piece {
	Tile tile;
	Boolean status;
	Boolean isSide1;

	public Boolean isInGame() {
		return status;
	}

	public Boolean getIsSide1() {
		return isSide1;
	}

	public Piece(Tile tile, Boolean isSide1) {
		this.status = true;
		this.tile = tile;
		this.isSide1 = isSide1;
		tile.setPiece(this);
	}

	public boolean getStatus(){
		return status;
	}

	public void setStatus(boolean a){
		status = a;
	}

	public Tile getTile(){
		return tile;
	}

	public void moveTo(Tile tile){
		this.tile.setPiece(null);
		this.tile = tile;
	}

	public abstract boolean canMoveHere(Board board, Position position);

	public abstract void display();
}
