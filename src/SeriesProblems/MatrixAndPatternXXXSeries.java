package SeriesProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixAndPatternXXXSeries {
	/**
	 * Google, Number of Islands, Number of Islands II
	 * @author Xuechao
	 *
	 */
	static class NumberOfIslands {
		public int numIslands(char[][] matrix) {
			if (matrix.length == 0) {
				return 0;
			}
			boolean[][] visited = new boolean[matrix.length][matrix[0].length];
			int ret = 0;

			Queue<Integer[]> q = new LinkedList<>();

			for (int i = 0; i < matrix.length; ++i) {
				for (int j = 0; j < matrix[0].length; ++j) {
					if (!visited[i][j] && matrix[i][j] == '1') {
						visited[i][j] = true;
						Integer[] found = {i, j};
						q.offer(found);
						while (!q.isEmpty()) {
							Integer[] top = q.poll();
							int m = top[0];
							int n = top[1];
							visited[m][n] = true;
							if ( m - 1 >= 0 && !visited[m-1][n]) {
								if (matrix[m-1][n] == '1') {
									Integer[] temp = {m-1, n};
									q.offer (temp);
								} 
								visited[m-1][n] = true;

							} 

							if ( n - 1 >= 0 && !visited[m][n-1]) {
								if (matrix[m][n-1] == '1') {
									Integer[] temp = {m, n-1};
									q.offer (temp);
								} 
								visited[m][n-1] = true;

							}

							if ( m + 1 < matrix.length && !visited[m+1][n]) {
								if (matrix[m+1][n] == '1') {
									Integer[] temp = {m+1, n};
									q.offer (temp);
								} 
								visited[m+1][n] = true;

							}

							if ( n + 1 < matrix[0].length && !visited[m][n+1]) {
								if (matrix[m][n+1] == '1') {
									Integer[] temp = {m, n+1};
									q.offer (temp);
								} 
								visited[m][n+1] = true;

							}
						}
						ret++;
					}
				}
			}

			return ret;
		}

		public List<Integer> numIslands2(int m, int n, int[][] positions) {
			//prepare directions
			int[][] directions = {
					{-1, 0}, {1, 0}, {0, -1}, {0, 1}
			};
			//edge cases
			//assume m > 0 ,n > 0
			// store island id. will be propagated out
			int[] roots = new int[m*n];
			Arrays.fill(roots, -1);

			//prepare result list
			List<Integer> result = new ArrayList<>();
			//prepare island numbers
			int count = 0;

			//traverse positions, add to final result list
			for (int[] coordinates : positions) {
				//assume this is a new island, root itself
				int x = coordinates[0];
				int y = coordinates[1];
				roots[x*n + y] = x*n + y;
				// record current island
				int rootCur = x*n + y;
				count++;

				for (int[] direction : directions) {
					// get neighbour coordinates
					int neighbourX = x + direction[0];
					int neighbourY = y + direction[1];
					//find boundary or water, continue
					if (neighbourX < 0 || neighbourX > m-1 || neighbourY < 0 || neighbourY  > n-1|| roots[neighbourX*n+neighbourY] == -1) {
						continue;
					}
					//find neighour's root
					int neighbourID = roots[neighbourX*n+neighbourY];
					while (neighbourID != roots[neighbourID]) {
						neighbourID = roots[neighbourID];
					}
					//if not same island, set current island to neighour's island. and set current island to neighour's island.
					if (neighbourID != rootCur) {
						roots[rootCur] = neighbourID;
						rootCur = neighbourID;
						count--;
					}
				}
				//add current island numbser to result list
				result.add(count);
			}

			//return result
			return result;
		}
	}

	public static void main (String[] args) {
		NumberOfIslands myIsland = new NumberOfIslands();
		char[][] input = {
				{'1', '1', '1'},
				{'0', '1', '0'},
				{'1', '1', '1'}
		};

		System.out.println("test 工: " +  myIsland.numIslands(input));
	}

}
