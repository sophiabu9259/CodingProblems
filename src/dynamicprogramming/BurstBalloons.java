package dynamicprogramming;

public class BurstBalloons {
	public int maxCoins (int[] balloons) {
		
		int[] nums = new int[balloons.length + 2];
		int n = 1;
		for (int x : balloons) {
			if (x > 0) {
				nums[n++] = x; //burst 0 marked balloons first why? because 0 marked balloons will waste the balloons beside zeros
			}
		}
		nums[0] = nums[n++] = 1;
		
		int[][] dp = new int[n][n]; // 
		
		for (int len = 3 ; len <= n; ++len) {
			for (int start = 0; start <= n - len; ++start) {
				int end = start + len - 1;
				for (int k = start + 1; k < end; ++k) {
					dp[start][end] = Math.max (dp[start][end], nums[start] * nums[k] * nums[end] + dp[start][k] + dp[k][end] ); //the (first, k, last) situation and the sum created during bursting into this situation 
				}
			}
		}

		return dp[0][n - 1];

	}
}
