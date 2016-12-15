package dynamicprogramming;
/**
 * use dp[i][j] for s1.sub(0,i) and s2.sub(0,j) to match s3.sub(0,i+j-1). i and j indicates length, not index.
 * @author Xuechao
 *
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
          return false;
        }
    
        boolean[][] partialMatch = new boolean[s1.length() + 1][s2.length() + 1];
        partialMatch[0][0] = true;
        
        for (int i = 1; i <= s1.length(); ++i) {//!!! <= not <
          partialMatch[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && partialMatch[i-1][0];
        }
    
        for (int i = 1; i <= s2.length(); ++i) { //!!!
          partialMatch[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && partialMatch[0][i-1];
        }
        for (int i = 1; i <= s1.length(); ++i) { //!!!
           for (int j = 1; j <= s2.length(); ++j) {
               partialMatch[i][j] = (s3.charAt(i+j-1) == s1.charAt(i-1) && partialMatch[i-1][j])
                                            || (s3.charAt(i+j-1) == s2.charAt(j-1) && partialMatch[i][j-1]);
               
            }
        }
        return partialMatch[s1.length()][s2.length()];
    }
}
