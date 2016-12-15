package lcArraysLinkedListsStrings;
/**dp[0][0] =true; dp[i][0]:if pattern is empty, all input is false;dp[0][j]:meet non* to break.only seq of *s can match "";dp[i][j] = dp[i-i][j-i] 
 * if s[i]==p[j]; dp[i-1][j] for * matched s[i] go check s[i-1];dp[i][j-1] for * matched nothing.
 * @author Xuechao
 *
 */
public class WildCardMatching {
	public boolean isMatch (String input, String pattern) {
		int m = input.length();
		int n = pattern.length();
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;
		int i = 0;
		int j = 0;
		//dp[i][0] = false for i = [1,m]
		for ( j = 1; j < n + 1; j++) {
			if ( pattern.charAt(j-1) == '*'){
				dp[0][j] = true;
			} else {
				break;
			}
		}
		
		for ( i = 1; i < m + 1; i++) {
			for ( j = 1; j < n + 1; j++){
				if ( pattern.charAt(j-1) != '*'){
					if ( pattern.charAt(j-1) == '?' || pattern.charAt(j-1) == input.charAt(i-1)) {
						dp[i][j] = dp[i-1][j-1];
					}
				} else {
					// dp[i][j] = dp[i][j-1]
					// * means none sequence
					// dp[i][j] = dp[i-1][j]
					// * means some sequence, we skip those in input
					// "a" and "c*****"?
					// looks like a and c* will get true because d[a][*] = d[''][*] or d[a][c] and d[''][*] = true
					// but d[0][*] is false because we dont set it as true once we met non-* chars.	
					dp[i][j] = dp[i][j-1] || dp[i-1][j];
				}
			}
		}
		
		return dp[m][n];
	}
}
