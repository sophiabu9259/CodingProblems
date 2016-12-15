package greedyanddynamicprogramming;
/**
 * update max reachable place for each position. Check final max and input length
 * @author xuechao
 *
 */
public class JumpGame {
	public boolean jumpable_greedy (int[] nums) {
		//edge cases
		int maxReach = 0;
		for (int i = 0; i <= maxReach && i < nums.length; ++i) {
			maxReach = Math.max(maxReach, nums[i]+i);
		}
		return maxReach >= nums.length-1;
	}
	
}
