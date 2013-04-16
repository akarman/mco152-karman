package karman.ticTacToe;

import java.util.Stack;

public class TicTacToeGame {
	private Stack<BoardGame> boardStack;
	private Move player;
	private int numGames;

	public TicTacToeGame() {
		boardStack = new Stack<BoardGame>();
		player = Move.X;
		pushInitialBoards();
		numGames = 0;

	}

	private void pushInitialBoards() {
		BoardGame b = new BoardGame();
		int[][] possibleMoves = b.getPossibleMoves();
		for (int i = 0; i < possibleMoves.length; i++) {
			b = new BoardGame();
			b.mark(player, possibleMoves[i][0], possibleMoves[i][1]);
			boardStack.push(b);
		}
	}

	private void pushNextBoards(BoardGame b) {
		changePlayer();
		int[][] possibleMoves = b.getPossibleMoves();
		for (int i = 0; i < possibleMoves.length; i++) {
			BoardGame newBoard = new BoardGame(b);
			newBoard.mark(player, possibleMoves[i][0], possibleMoves[i][1]);
			boardStack.push(newBoard);
		}
	}

	public void playGame() {
		while (!boardStack.isEmpty()) {
			BoardGame topBoard = boardStack.pop();
			if (!topBoard.gameOver()) {
				pushNextBoards(topBoard);
			} else {
				numGames++;
				if (topBoard.gameWon()) {
					System.out.println(topBoard.getWinner()
							+ " IS THE WINNER!!\n");
				} else {
					System.out.println("Game Over, No Winner.\n");
				}
				topBoard.displayBoard();
				System.out.print("\n");
			}
		}
		System.out.println("Number of games " + numGames);
	}

	private void changePlayer() {
		switch (player) {
		case X:
			player = Move.O;
			break;
		case O:
			player = Move.X;
			break;
		default:
			break;

		}
	}

	public static void main(String[] args) {
		TicTacToeGame ticTacToe = new TicTacToeGame();
		ticTacToe.playGame();
	}
}
