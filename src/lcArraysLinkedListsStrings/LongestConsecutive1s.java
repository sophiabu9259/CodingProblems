package lcArraysLinkedListsStrings;



public class LongestConsecutive1s {
	public int findMax (int[] input) {
		if (input == null || input.length == 0) return 0;
		int maxLen = Integer.MIN_VALUE;
		int curLen = 0;
		for (int i = 0; i < input.length; ++i) {
			if (input[i] == 1) {
				curLen++;
				maxLen = Math.max ( maxLen, curLen);
			} else {
				curLen = 0;
			}
		}
		return maxLen;
	}







	public int findMaxWithFlip (int[] input) {
		if (input == null || input.length == 0) return 0;
		int maxLen = Integer.MIN_VALUE;
		int curLen = 0;
		int spareLen = 0;
		boolean zero = false;

		for (int i = 0; i < input.length; ++i) {
			if (input[i] == 1) {
				curLen++;
				spareLen++;
			} else {
				maxLen = Math.max ( maxLen, curLen + spareLen + 1);
				curLen = spareLen;
				spareLen = 0;
			}
		}
		maxLen = Math.max (maxLen,zero ? curLen + spareLen + 1 : curLen);
		return maxLen;
	}
}


