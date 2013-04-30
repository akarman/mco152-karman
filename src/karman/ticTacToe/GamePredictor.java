package karman.ticTacToe;

import java.util.ArrayList;
import queue.*;

public class GamePredictor {

	private ArrayList<BoardGame> tempWinArray;
	private Queue<BoardGame> tempQueue;
	

	public GamePredictor() {
		tempWinArray = new ArrayList<BoardGame>();
		tempQueue = new Queue<BoardGame>();
	}

	public void bestNextMove(BoardGame b) {
		bestNextMove(b, b.getNumMoves() + 1);
	}

	public void bestNextMove(BoardGame b, int moveNumber) {
		int[][] possibleMoves = b.getPossibleMoves();
		for (int i = 0; i < possibleMoves.length; i++) {
			BoardGame newBoard = new BoardGame(b);
			newBoard.mark(newBoard.getCurrentPlayer(), possibleMoves[i][0], possibleMoves[i][1]);
			if (newBoard.gameWon()) {
				tempWinArray.add(newBoard);
			} else {
				tempQueue.enqueue(newBoard);
			}

		}
		if (!tempWinArray.isEmpty()) {
			for (int i = 0; i < tempWinArray.size(); i++) {
				BoardGame winningBoard = tempWinArray.get(i);
				System.out.println("Winner: " +winningBoard.getWinner());
				for(int m=moveNumber;m<=winningBoard.getNumMoves();m++){
					System.out.println("Move number " + m + ": row-"
							+ winningBoard.getPastMoves()[m - 1][0]
							+ " col-"
							+ winningBoard.getPastMoves()[m - 1][1]);
				}
				
				System.out.println("leads to the following winning board:");
				winningBoard.displayBoard();
				System.out.println();
			}
		} else {
			while (!tempQueue.isEmpty()) {
				bestNextMove(tempQueue.dequeue(), moveNumber);
			}
		}

	}


	public static void main(String[] args) {
		GamePredictor g = new GamePredictor();
		BoardGame b = new BoardGame();
		b.markO(0, 2);
		b.markO(1, 2);
		b.markX(1, 1);
		b.markX(2, 0);

		// System.out.println("this is starting board");
		// b.displayBoard();
		g.bestNextMove(b);
	}

}
