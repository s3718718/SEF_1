package Piece;
import Game.*;

public class Rook extends Piece{

	public Rook(Tile tile, Boolean isSide1) {
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
			if (desX == pieceX && desY == pieceY+1){
				return true;
			}
			else if (desX == pieceX+1 && desY == pieceY){
				return true;
			}
			else if (desX == pieceX && desY == pieceY-1){
				return true;
			}
			else if (desX == pieceX-1 && desY == pieceY){
				return true;
			}
			else if (desX == pieceX-2 && desY == pieceY){
				if (board.tiles[pieceX-1][pieceY].isPieceHere() == true)
					return false;
				else return true;
			}
			else if (desX == pieceX && desY == pieceY+2){
				if (board.tiles[pieceX][pieceY+1].isPieceHere() == true)
					return false;
				else return true;
			}
			else if (desX == pieceX+2 && desY == pieceY){
				if (board.tiles[pieceX+1][pieceY].isPieceHere() == true)
					return false;
				else return true;
			}
			else if (desX == pieceX && desY == pieceY-2){
				if (board.tiles[pieceX][pieceY-1].isPieceHere() == true)
					return false;
				else return true;
			}
			else return false;
		}
	}

	@Override
	public void display() {
		if (isSide1 == true)
			System.out.print("R");
		else System.out.print("r");
	}

}
