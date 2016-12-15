package dynamicprogramming;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 0 ){
            return 0;
        }
       
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; ++i) {
        	if (nums[i] >=0 && dp[i-1] >=0) {
        	    dp[i] = dp[i-1] + nums[i];
        	} else if (nums[i] >= 0 && dp[i-1] < 0) {
        	    dp[i] = nums[i];
        	} else if (nums[i] <=0 && nums[i] + dp[i-1] >= 0) {
        	    dp[i] = dp[i-1] + nums[i];
        	} else {
        	    dp[i] = nums[i];
        	}
        }
        int max = dp[0];
        for (int e : dp) {
        	max = Math.max(max,	e);
        }
        return max;
    }
}
