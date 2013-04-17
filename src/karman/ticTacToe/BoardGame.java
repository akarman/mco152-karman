package karman.ticTacToe;

import java.util.ArrayList;

public class BoardGame {
	private Move[][] board;
	private Move winner;
	private int[][] possibleMoves;

	public BoardGame() {
		board = new Move[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col] = Move.EMPTY;
			}
		}
		possibleMoves = this.getNextMoves();
		winner = Move.EMPTY;
	}

	public BoardGame(BoardGame orig) {
		board = new Move[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col] = orig.board[row][col];
			}
		}
		possibleMoves = this.getNextMoves();
		winner = orig.winner;
	}

	public int[][] getPossibleMoves() {
		return this.getNextMoves();
	}

	public Move[][] getBoard() {
		return board;
	}

	public ArrayList<Move> getBoardArrayList() {
		ArrayList<Move> boardArrayList = new ArrayList<Move>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				boardArrayList.add(board[row][col]);
			}
		}
		return boardArrayList;
	}

	public void mark(Move move, int row, int col) {
		board[row][col] = move;
		possibleMoves = getNextMoves();
	}

	public void markX(int row, int col) {
		mark(Move.X, row, col);
	}

	public void markO(int row, int col) {
		mark(Move.O, row, col);
	}

	public boolean gameOver() {
		if (gameWon()) {
			return true;
		}
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == Move.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean gameWon() {
		if (verticalColWin()) {
			return true;
		}
		if (horizontalRowWin()) {
			return true;
		}
		if (diagonalRowWin()) {
			return true;
		}
		return false;
	}

	private boolean verticalColWin() {
		boolean won = false;
		for (int col = 0; col < 3; col++) {
			if (checkVerticalCol(col)) {
				won = true;
				break;
			}
		}
		return won;
	}

	private boolean checkVerticalCol(int col) {
		int row = 0;
		while (row < 2) {
			if (board[row][col] == Move.EMPTY
					|| board[row][col] != board[++row][col]) {
				return false;
			}
		}
		winner = board[row--][col];
		return true;
	}

	private boolean horizontalRowWin() {
		boolean won = false;
		for (int row = 0; row < 3; row++) {
			if (checkHorizontalRow(row)) {
				won = true;
				break;
			}
		}
		return won;
	}

	private boolean checkHorizontalRow(int row) {
		int col = 0;
		while (col < 2) {
			if (board[row][col] == Move.EMPTY
					|| board[row][col] != board[row][++col]) {
				return false;
			}
		}
		winner = board[row][col--];
		return true;
	}

	private boolean diagonalRowWin() {
		int row = 0;
		int col = 0;

		if (board[row][col] != Move.EMPTY) {
			if (board[row][col] == board[++row][++col]
					&& board[row][col] == board[++row][++col]) {
				winner = board[row][col];
				return true;
			}
		}

		row = 0;
		col = 2;
		if (board[row][col] != Move.EMPTY) {
			if (board[row][col] == board[++row][--col]
					&& board[row][col] == board[++row][--col]) {
				winner = board[row][col];
				return true;
			}
		}

		return false;
	}

	public void displayBoard() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				Move position = board[row][col];
				if (position == Move.EMPTY) {
					System.out.print(" \t");
				} else if (position == Move.X) {
					System.out.print("X\t");
				} else {
					System.out.print("O\t");
				}
			}
			System.out.print("\n");
		}
	}

	private int[][] getNextMoves() {
		int[][] movesArray = new int[9][2];
		int numMoves = 0;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == Move.EMPTY) {
					movesArray[numMoves][0] = row;
					movesArray[numMoves][1] = col;
					numMoves++;
				}
			}
		}
		int[][] packedMovesArray = new int[numMoves][2];
		for (int i = 0; i < numMoves; i++) {
			packedMovesArray[i][0] = movesArray[i][0];
			packedMovesArray[i][1] = movesArray[i][1];
		}
		return packedMovesArray;
	}

	public Move getWinner() {
		return winner;
	}
}
