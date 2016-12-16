package lcArraysLinkedListsStrings;

import java.util.Arrays;

/**
 * About Optimization: Sorting takes O(nlogn) time. If we want to try O(logn) time for each element in nums as tuple[0], we have to find the closest
 * in logn time. Right now there is no approach for finding this pair within O(logn) time.
 * @author xuechao
 *
 */
public class ThreeSumClosest {
	public int threeSumClosest (int[] nums, int target) {
		
		if (nums == null || nums.length < 3) return 0;
		Arrays.sort(nums);
		
		//update min and res when finding a smaller distance to the target
		int min = Integer.MAX_VALUE;
		int i = 0;
		int res = 0;
		while (i < nums.length - 2) {

			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int temp = nums[i] + nums[j] + nums[k];
				if (Math.abs(temp - target) < min) {
					min = Math.abs(temp - target);
					res = temp;
				} 
				//no matter we updated min or not, try to approach the target.
				if (temp < target) {
					j++;
				} else {
					k--;
				}
	
			}
			i++;
		}
		return res;
	}
	
	public static void main (String[] args) {
		ThreeSumClosest o = new ThreeSumClosest();
		int[] test = {
			0,1,1,1	
		};
		
		System.out.println ("Test right max..." + (o.threeSumClosest(test,100) == 3) );
	}
}
