package karman.ticTacToe;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BoardGameTest {

	@Test
	public void testMark() {
		BoardGame testBoard = new BoardGame();
		testBoard.mark(Move.X, 1, 1);
		assertEquals(Move.X, testBoard.getBoard()[1][1]);
	}

	@Test
	public void testMarkX() {
		BoardGame testBoard = new BoardGame();
		testBoard.markX(1, 1);
		assertEquals(Move.X, testBoard.getBoard()[1][1]);
	}

	@Test
	public void testMarkO() {
		BoardGame testBoard = new BoardGame();
		testBoard.markO(1, 1);
		assertEquals(Move.O, testBoard.getBoard()[1][1]);
	}

	@Test
	public void testGameOverHorizontalWin() {
		BoardGame testBoard = new BoardGame();
		testBoard.mark(Move.X, 0, 0);
		testBoard.mark(Move.X, 0, 1);
		testBoard.mark(Move.X, 0, 2);

		assertTrue(testBoard.gameOver());
	}

	@Test
	public void testGameOverVerticalWin() {
		BoardGame testBoard = new BoardGame();
		testBoard.mark(Move.O, 0, 0);
		testBoard.mark(Move.O, 1, 0);
		testBoard.mark(Move.O, 2, 0);

		assertTrue(testBoard.gameOver());
	}

	@Test
	public void testGameOverDiagonalWin() {
		BoardGame testBoard = new BoardGame();
		testBoard.mark(Move.X, 0, 0);
		testBoard.mark(Move.X, 1, 1);
		testBoard.mark(Move.X, 2, 2);

		assertTrue(testBoard.gameOver());
	}

	@Test
	public void testGameOverBoardFull() {
		BoardGame testBoard = new BoardGame();
		testBoard.mark(Move.X, 0, 0);
		testBoard.mark(Move.O, 0, 1);
		testBoard.mark(Move.X, 0, 2);
		testBoard.mark(Move.X, 1, 0);
		testBoard.mark(Move.O, 1, 1);
		testBoard.mark(Move.X, 1, 2);
		testBoard.mark(Move.O, 2, 0);
		testBoard.mark(Move.X, 2, 1);
		testBoard.mark(Move.O, 2, 2);

		assertTrue(!testBoard.gameWon());
		assertTrue(testBoard.gameOver());
	}

	@Test
	public void testGetPossibleMoves() {
		BoardGame testBoard = new BoardGame();
		testBoard.mark(Move.X, 0, 0);
		testBoard.mark(Move.O, 0, 1);
		testBoard.mark(Move.X, 0, 2);
		testBoard.mark(Move.X, 1, 0);
		testBoard.mark(Move.O, 1, 1);
		testBoard.mark(Move.X, 1, 2);
		testBoard.mark(Move.O, 2, 0);
		testBoard.mark(Move.X, 2, 1);
		int[][] movesArray = testBoard.getPossibleMoves();
		assertEquals(2, movesArray[0][0]);
		assertEquals(2, movesArray[0][1]);
	}

	@Test
	public void testProgramTime() {
		TicTacToeGame testTTT = new TicTacToeGame();
		testTTT.playGame();
	}

}
