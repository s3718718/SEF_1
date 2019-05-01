package Piece;
import Game.*;

public class Knight extends Piece{

	public Knight(Tile tile, Boolean isSide1) {
		super(tile, isSide1);
	}

	@Override
	public boolean canMoveHere(Board board, Position position) {
		int desX = position.getX();
		int desY = position.getY();
		int pieceX = tile.getPosition().getX();
		int pieceY = tile.getPosition().getY();
		if (desX>5 || desX <0 || desY>5 || desY<0){
			return false;
		}
		else {
			if (desX == pieceX+2 && desY == pieceY+1)
				return true;
			else if (desX == pieceX+2 && desY == pieceY-1)
				return true;
			else if (desX == pieceX+1 && desY == pieceY-2)
				return true;
			else if (desX == pieceX-1 && desY == pieceY-2)
				return true;
			else if (desX == pieceX-2 && desY == pieceY-1)
				return true;
			else if (desX == pieceX-2 && desY == pieceY+1)
				return true;
			else if (desX == pieceX-1 && desY == pieceY+2)
				return true;
			else if (desX == pieceX+1 && desY == pieceY+2)
				return true;
			else return false;
		}
	}

	@Override
	public void display() {
		if (isSide1 == true)
			System.out.print("K");
		else System.out.print("k");
	}

}
