package SeriesProblems;

public class SubStringDPSeries {
	static class LongestPalindromeSubstring {
		public String longestPalindrome(String s) {
			if (s == null || s.length() == 0) {
				return null;
			}
			boolean[][] dp = new boolean[s.length()][s.length()];
			int start = 0;
			int max = 0;
			for (int i = 0; i < s.length(); ++i) {
				dp[i][i] = true;
			}
			for (int i = 0; i < s.length(); ++i) {
				for (int j = 0; j < i; ++j) {
					dp[i][j] = (s.charAt(i) == s.charAt(j) && i - j == 1) || (s.charAt(i) == s.charAt(j) && dp[j+1][i-1]);

					if (dp[i][j] && i + 1 - j > max) {
						max = Math.max(max, i + 1 -j);
						start = j;
					}
				}
			}

			return s.substring(start, start+max);
		}
	}
}
