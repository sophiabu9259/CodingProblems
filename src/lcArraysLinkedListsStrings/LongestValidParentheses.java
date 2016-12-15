package lcArraysLinkedListsStrings;
/**
 * Also forward/backward scanning and use stack to record 
 * @author Xuechao
 *
 */
public class LongestValidParentheses {
	/**
	 * open	000010123210		 open	000010123210
	 * 		))))()((()))   ->  			))))()((()))
 	 * dp	000002000246				000002000248
 	 * 			 ^     ^					 ^     ^
	 */
	public int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int open = 0;
		int max = 0;
		for ( int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				open++;
			} else {
				if (open > 0) {
					dp[i] = dp[i-1] + 2;
					if (i-dp[i] > 0) {
						dp[i] += dp[i-dp[i]];
					}
					open--;
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}
}
