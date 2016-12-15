package dynamicprogramming;

public class UniquePath2 {
	public int uniquePathsWithObstacles (int[][] matrix) {
		if(matrix.length == 0) return 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		dp[0][0] = matrix[0][0] == 0? 1 : 0;
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = matrix[i][0] == 1? 0 : dp[i-1][0];
		}
		
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = matrix[0][j] == 1? 0 : dp[0][j-1];
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = matrix[i][j] == 1? 0 : dp[i][j-1] + dp[i-1][j];
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
