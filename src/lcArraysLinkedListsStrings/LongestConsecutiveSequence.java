package lcArraysLinkedListsStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	/**
	* Read in all the numbers to a set.
	* then traverse again. for each number. try expand to two directions to the most until cannot
	* find next consecutive number.
	*
	*/

	public int longestConsecutive (int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}

		int max = 0;

		int i = 0;
		while (i < nums.length) {
			int cur = nums[i];
			int size = 0;
			while (set.contains(cur)) {
				set.remove(cur++);
				size++;
			}

			cur = nums[i] - 1;
			while (set.contains(cur)) {
				set.remove(cur--);
				size++;
			}

			max = Math.max(max, size);
			i++;
		}

		return max;

	}

	public static void main (String[] args) {
		LongestConsecutiveSequence o = new LongestConsecutiveSequence();
		int[] test1 = null;
		int[] test2 = {};
		int[] test3 = {1,1,1,1,1,1};
		int[] test4 = {100,4,200,1,3,2};
		int[][] testsuite = {test1, test2, test3, test4};
		int[] result = {0,0,1,4};

		int i = 0;
		while (i < testsuite.length) {
			System.out.println ("Testing " + i + "..." + (o.longestConsecutive(testsuite[i]) == result[i]));
			i++;
		}
	}
}
