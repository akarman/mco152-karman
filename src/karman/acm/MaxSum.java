package karman.acm;

import java.util.Random;

public class MaxSum {
	private int n;
	private int[][] array2D;
	private int max;
	private int originRow;
	private int originCol;
	private int endRow;
	private int endCol;

	public MaxSum(int n) throws Exception {
		if (n < 1 || n > 100) {
			throw new Exception("Invalid array dimensions");
		}
		this.n = n;
		this.array2D = new int[n][n];
		max = 0;
		addNumbers();
		originRow = -1;
		originCol = -1;
		endRow = -1;
		endRow = -1;
	}

	public MaxSum(int n, int[] array) throws Exception {
		if (n < 1 || n > 100) {
			throw new Exception("Invalid array dimensions");
		}

		this.n = n;
		this.array2D = new int[n][n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array2D[i][j] = array[index++];
			}
		}

		max = 0;
		originRow = -1;
		originCol = -1;
		endRow = -1;
		endRow = -1;

	}

	private void addNumbers() {
		Random random = new Random();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array2D[i][j] = -127 + random.nextInt(256);
			}
		}
	}

	public int getMaxSum() {
		for (int startRow = 0; startRow < n; startRow++) {
			for (int startCol = 0; startCol < n; startCol++) {
				getSubArrays(startRow, startCol);
			}
		}
		return max;
	}

	private void getSubArrays(int startRow, int startCol) {
		for (int endRow = startRow; endRow < n; endRow++) {
			for (int endCol = startCol; endCol < n; endCol++) {
				getRectangleSum(startRow, startCol, endRow, endCol);
			}
		}
	}

	private void getRectangleSum(int startRow, int startCol, int endRow,
			int endCol) {
		int rectSum = 0;
		for (int currRow = startRow; currRow <= endRow; currRow++) {
			for (int currCol = startCol; currCol <= endCol; currCol++) {
				rectSum += array2D[currRow][currCol];
			}
		}
		if (rectSum > max) {
			max = rectSum;
			originRow = startRow;
			originCol = startCol;
			this.endRow = endRow;
			this.endCol = endCol;
		}
	}

	public int getOriginRow() {
		return originRow;
	}

	public int getOriginCol() {
		return originCol;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getEndCol() {
		return endCol;
	}

}
