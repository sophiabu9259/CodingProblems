package greedyanddynamicprogramming;
/**
 * from the first jump range, for each largest jump range, go through it to update next largest jump range.
 * After the jump, pick the largest one during this range traversal as next biggest range.
 * @author xuechao
 *
 */
public class JumpGame2 {
	public int minimumJumps (int[] nums) {
		int jumpCount = 0;
		int maxRange = 0;
		int nextMaxRange = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (i > maxRange) {
				jumpCount++;
				maxRange = nextMaxRange;
			}
			nextMaxRange = Math.max(nextMaxRange, nums[i] + i);
		}
		return jumpCount;
	}
}
