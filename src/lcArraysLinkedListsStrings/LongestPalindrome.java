package lcArraysLinkedListsStrings;

import java.util.Arrays;

public class LongestPalindrome {
	public String longestPalinDrome (String input) {
		int len = input.length();
		boolean[][] dp = new boolean[len][len];
		for ( boolean[] row:dp ) {
			Arrays.fill(row, false);
		}
		
		int start = 0;
		int maxLen = 1;
		
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
			for (int j = 0; j < i; j++) {
				dp[i][j] = (input.charAt(i) == input.charAt(j) && i - j == 1) || (input.charAt(i) == input.charAt(j) && dp[i-1][j+1]);
				if (dp[i][j] && i-j+1 > maxLen) {
					maxLen = i-j+1;
					start = j;
				}
			}
		}
		
		return input.substring(start, start+maxLen);
	}
}
