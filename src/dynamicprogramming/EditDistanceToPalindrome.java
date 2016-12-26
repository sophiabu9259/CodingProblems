package dynamicprogramming;

public class EditDistanceToPalindrome {
	
	public int findDistToPalindrome (String s) {
		/**
		 * 1. if you have to insert some char to make a palindrome, deleting its counterpart works same way, abd vice versa
		 * 2. base case build up, from both end towards center, compare the chars.
		 * 3. get the min of insertion/deleteion(notice two directions to do this) and replacing one char. 
		 * in abgEa casem replacing takes 1, insertion/deletion takes 2
		 * 4. can also be done in dynamic programming similarly
		 * 5. similar to burst balloons
		 */
		return util (s, 0, s.length() - 1);
	}
	
	public int util (String s, int l, int h) {
		if (l >= h) return 0;
		int mid = util (s, l + 1, h - 1);
		if (s.charAt (l) == s.charAt(h)) {
			return mid;
		} else {
			int left = util (s, l, h - 1);
			int right = util (s, l + 1, h);

			return Math.min(Math.min (left + 1, right + 1), mid + 1);
		}
	}
	
	public static void main (String[] args) {
		String[] testsuite = {
				"", "a", "aa", "ab", "abcde", "cEgbc", "cEagac", "mohammadsajjadhossain", "xuechaow"
		};
		
		int[] resultList = {
				0, 0, 0, 1, 2, 1, 1, 8, 4
		};
		
		EditDistanceToPalindrome o = new EditDistanceToPalindrome();
		for (int i = 0; i < testsuite.length; ++i) {
			String s = testsuite[i];
			System.out.println(s + ", " + (o.findDistToPalindrome(s) == resultList[i]) );
		}
	}
}
