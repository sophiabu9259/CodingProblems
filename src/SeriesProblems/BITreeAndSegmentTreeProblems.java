package SeriesProblems;

public class BITreeAndSegmentTreeProblems {
	/**
	 * Use Binary Index Tree
	 * @author Xuechao
	 *
	 */
	static class NumMatrix {
		/*
		 * matrix is for storing the matrix. optional for only requireing range sum
		 */
		private int[][] BITree;
		private int[][] matrix;
		final int m;
		final int n;
		/*
		 * Initialize BITree. Use update function for every element.
		 */
		public NumMatrix(int[][] matrix) {
			//assume valid matrix
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
				m = 0;
				n = 0;
				return;
			}
			m = matrix.length;
			n = matrix[0].length;
			BITree = new int[m+1][n+1];
			this.matrix = new int[m][n];

			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					update (i, j, matrix[i][j]);
				}
			}      
		}
		/**
		 * updating is a bottom-up function to sum certain index's value into its upper level parents.
		 * @param row
		 * @param col
		 * @param val
		 */
		public void update(int row, int col, int val) {
			int delta = val - this.matrix[row][col];
			this.matrix[row][col] = val;

			for (int x = row + 1; x <= m; x += (x & (-x))) {
				for (int y = col + 1; y <= n; y += (y & (-y))) {
					BITree[x][y] += delta;
				}
			}
		}
		/*
		 * call BIT sum to get the target region
		 */
		public int sumRegion(int row1, int col1, int row2, int col2) {
			return sumFromOrigin (row2, col2) + sumFromOrigin (row1-1, col1-1) - sumFromOrigin (row1-1, col2) - sumFromOrigin (row2, col1-1);
		}
		/*
		 * Summing in BITree is a up-bottom operation. Get the target index value's and all its sub-level sums
		 * which are only stored in sub-level parents to avoid 0(n) operation.
		 */
		private int sumFromOrigin (int row, int col) {
			if (row < 0 || col < 0) {
				return 0;
			}

			int sum = 0;

			for (int i = row + 1; i > 0; i -= (i & (-i))) {
				for (int j = col + 1; j > 0; j -= (j & (-j))) {
					sum += BITree[i][j];
				}
			}

			return sum;
		}

	}
}
