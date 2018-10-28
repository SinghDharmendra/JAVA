package ps.dynamic.programming;

public class FindMaxSumForDiagonalTraversal {
	public static void main(String[] args) {

		int in[][] = { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 }, { 2, 0, 0, 0, 0 } };
		System.out.println(calculate(in));

	}

	private static int calculate(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		System.out.println(r + ", " + c);
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = 0; j < grid[0].length; j++) {
				int prev = 0, down = 0;
				if (isValid(i, j - 1, r, c))
					prev = grid[i][j - 1];
				if (isValid(i + 1, j, r, c))
					down = grid[i + 1][j];
				grid[i][j] = grid[i][j] + (prev >= down ? prev : down);
				System.out.print(grid[i][j] + " ");

			}
			System.out.println();

		}

		return grid[0][grid[0].length - 1];
	}

	private static boolean isValid(int i, int j, int r, int c) {

		return (i >= 0 && i < r) && (j >= 0 && j < c);
	}

}
