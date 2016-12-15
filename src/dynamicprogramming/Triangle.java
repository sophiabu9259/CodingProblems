package dynamicprogramming;

import java.util.List;

/**
 * DFS->found duplicate subproblems--
 * 									|
 * 									--> DP -> up to bot -> o(n^2)-> bot to up -> o(n)s pace
 * @author Xuechao
 *
 */
public class Triangle {
	public int minPathSum (int[][] triangle) {
		return backtracking(triangle, 0, 0);
	}
	
	public int backtracking (int[][] triangle, int row, int col) {
		if (row == triangle.length-1) {
			return triangle[row][col];
		} else {
			return triangle[row][col] + Math.min(backtracking (triangle, row+1, col), backtracking(triangle, row+1, col+1));
		}
	}
	
	public int minPathSum_DP (List<List<Integer>> triangle) {
		int[] dp = new int[triangle.get(triangle.size()-1).size()];
		for (int i = triangle.size()-2; i >= 0; i++) {
			for (int j = 0; j < triangle.get(i).size(); ++j) {
				if (i == triangle.size()-2) {
					dp[j] = triangle.get(i).get(j);
				} else {
					dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
				}
			}
		}
		return dp[0];
	}
}
