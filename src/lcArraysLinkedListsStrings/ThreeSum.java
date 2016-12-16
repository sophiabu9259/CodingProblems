package lcArraysLinkedListsStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> findThreeSum (int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) return res;
		Arrays.sort (nums);

		int i = 0;
		while (i < nums.length - 2) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] + nums[i] < 0) {
					//TODO move up j to next different element
					j = nextDiff(nums, j, true);
				} else if ( nums[i] + nums[j] + nums[k] > 0) {
					//TODO move down k to next different element
					k = nextDiff(nums, k, false);
				} else {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					res.add(temp);
					//TODO move j, k to next different element
					j = nextDiff(nums, j, true);
					k = nextDiff(nums, k, false);
				}
			}
			//TODO move i to next different element;
			i = nextDiff(nums, i, true);
		}
		return res;
	} 

	private int nextDiff (int[] nums, int start, boolean larger) {
		int i = start;
		if (larger) {//find next larger one
			while (i < nums.length - 1) {
				if (nums[i + 1] > nums[i]) {
					return i + 1;
				}
				i++;
			}
		} else {//find next smaller one
			while (i >= 1) {
				if (nums[i - 1] < nums[i]) {
					return i - 1;
				}
				i--;
			}
		}


		return i;
	}

	public static void main (String[] args) {
		ThreeSum o = new ThreeSum();
		o.findThreeSum(new int[]{-1,0,1,2,-1,-4});

	}
}


