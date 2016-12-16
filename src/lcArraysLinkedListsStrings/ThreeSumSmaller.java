package lcArraysLinkedListsStrings;

import java.util.Arrays;

public class ThreeSumSmaller {
	public int findThreeSmaller (int[] nums, int target) {
		if (nums == null || nums.length < 3) return 0;
		Arrays.sort (nums);
		int res = 0;

		int i = 0;


		while (i < nums.length - 2) {

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				if (nums[i] + nums[j] + nums[k] >= target) {
					k--;
				}else {
					res += k - j;
					j++;
				}
			}

			i++;
		}

		return res;
	}
