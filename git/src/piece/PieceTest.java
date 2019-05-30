package piece;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Board;
import game.Player;
import game.Tile;

public class PieceTest
{
	//Note: Some Tests don't work as the method they used
	//		was made redundant (by the GUI) in the use of the program
	Board board;
	Rook rook;
	Knight knight;
	Bishop bishop;
	Player player1;
	Player player2;
	Piece[] whiteSide;
	Piece[] blackSide;
	@Before
	public void setUp() throws Exception 
	{
		board = new Board();
		whiteSide = new Piece[6];
		blackSide = new Piece[6];
		rook = new Rook(board.tiles[0][0], true);
		bishop = new Bishop(board.tiles[0][2], true);
		knight = new Knight(board.tiles[2][2], true);
		whiteSide[0] = rook;
		whiteSide[1] = bishop;
		whiteSide[2] = knight;
		blackSide[1] = new Rook(board.tiles[1][0], false);
		blackSide[2] = new Bishop(board.tiles[1][3], false);
		player1 = new Player(whiteSide, true);
		player2 = new Player(blackSide, false);
	}
	
	@After
	public void tearDown() throws Exception
	{
	}

//	@Test
//	public void testRook() throws Exception
//	{
//		assertTrue("testRook", rook.canMove(1, 0, board) == true);
//	}
//	
//	@Test
//	public void testRookFail()
//	{
//		assertTrue("testRookFail", rook.canMove(1, 1, board) == false);
//	}
//	
//	@Test
//	public void testRookBlocked() 
//	{
//		assertTrue("testRookBlocked", rook.canMove(2, 0, board) == false);
//	}
	
	@Test
	public void testRookAllMoves() 
	{
		ArrayList<Tile> possibleMovements = new ArrayList<Tile>();
		possibleMovements.add(board.getTile(1, 0));
		possibleMovements.add(board.getTile(0, 1));
		assertTrue("testRookAllMoves", rook.allMovements(board)
				.containsAll(possibleMovements));
	}
	
//	@Test
//	public void testBishop()
//	{
//		assertTrue("testBishop", bishop.canMove(1 , 1, board) == true);
//	}
//	
//	@Test
//	public void testBishopFail()
//	{
//		assertTrue("testBishopFail", bishop.canMove(3, 2, board) == false);
//	}
//	
//	@Test
//	public void testBishopBlocked()
//	{
//		assertTrue("testBishopBlocked", bishop.canMove(2, 4, board) == false);
//	}
	
	@Test
	public void testBishopAllMoves()
	{
		ArrayList<Tile> possibleMovements = new ArrayList<Tile>();
		possibleMovements.add(board.getTile(1, 1));
		possibleMovements.add(board.getTile(2, 0));
		possibleMovements.add(board.getTile(1, 3));
		assertTrue("testBishopAllMoves", bishop.allMovements(board)
				.containsAll(possibleMovements));
	}
	
//	@Test
//	public void testKnight()
//	{
//		assertTrue("testKnight", knight.canMove(0, 3, board) == true);
//	}
//	
//	@Test
//	public void testKnightFail()
//	{
//		assertTrue("testKnightFail", knight.canMove(4, 2, board) == false);
//	}
//
//	@Test
//	public void testKnightBlocked()
//	{
//		assertTrue("testKnightBlocked", knight.canMove(0, 2, board) == false);
//	}
	
	@Test
	public void testKnightAllMoves()
	{	//2 2 -	4,1	0,3 4,3	3,4	3,0	1,4	1,0
		ArrayList<Tile> possibleMovements = new ArrayList<Tile>();
		possibleMovements.add(board.getTile(4, 1));
		possibleMovements.add(board.getTile(4, 3));
		possibleMovements.add(board.getTile(0, 3));		
		possibleMovements.add(board.getTile(3, 4));
		possibleMovements.add(board.getTile(3, 0));
		possibleMovements.add(board.getTile(1, 4));
		possibleMovements.add(board.getTile(1, 0));
		assertTrue("testKnightAllMoves", knight.allMovements(board)
				.containsAll(possibleMovements));
	}
}
