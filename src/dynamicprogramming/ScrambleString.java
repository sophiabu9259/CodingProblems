package dynamicprogramming;
/**
 * 1. dfs + loopbreaking: compare 0 ~ len as splitting position. Check both splitting from start and from end.
 * 2. dfs + hashmap: use string combination as hash key to avoid re-calculating
 * 3. dp: dp[n][i][j] -> length n, s1 start from i, s2 start from j. are they scramble pairs.
 * @author Xuechao
 *
 */
public class ScrambleString {
	public class Solution {
	    public boolean isScramble(String s1, String s2) {
	          if (s1.equals(s2)) return true;
	        
	            int[] letter = new int[26];
	            for (int i = 0; i < s1.length(); ++i) {
	                letter[s1.charAt(i) - 'a']++;
	                letter[s2.charAt(i) - 'a']--;
	            }
	            for (int e : letter) {
	                if (e != 0) {
	                    return false;
	                }
	            }
	        
	            for (int i = 1; i < s1.length(); ++i) {
	                if ((isScramble (s1.substring(0, i), s2.substring(0,i)) && isScramble (s1.substring(i), s2.substring(i)))
	                    || (isScramble (s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble (s1.substring(i), s2.substring(0, s1.length()-i)) )) return true;
	            } 
	        
	            return false;
	    }
	}
}
