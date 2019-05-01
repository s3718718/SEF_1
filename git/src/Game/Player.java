package Game;
import Piece.Piece;

public class Player {
	private Piece[] pieces;
	private int score=0;
	private boolean side;
	
	public Player(Piece[] pieces, boolean side) {
		//Instantiate player
		this.pieces = pieces;
		this.side = side;
	}
	
	public boolean isInGame(){
		int piecesInGame = 6;
		for (int x=0;x > pieces.length ;x++){
			if (pieces[0].getStatus() == false){
				piecesInGame--;
			}
		}
		if (piecesInGame < 1){
			return false;
		}
		else return true;
	}
	
	public Piece getPiece(int index){
		return pieces[index];
	}
	
	public Piece[] getPieces(){
		return pieces;
	}
	
	public boolean getSide(){
		return side;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int newScore){
		score = newScore;
	}


}
