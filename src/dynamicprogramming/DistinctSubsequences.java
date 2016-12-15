package dynamicprogramming;
/**
 * f[i][j] stands for s.sub(0,i) to transform into t.sub(0,j).
 * case 1: i == j : look for last char
 * case 2: i < J: impossible
 * case 3: i > j:
 * 		sub case 1: last char equals : dont move last char of s. or delete it, let the remaining to map into t
 *      sub case 2: last char not equal: only can 0,i-1 be possible to map into 0,j.
 * @author Xuechao
 *
 */
public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int[][] f = new int[s.length()+1][t.length()+1];

		for (int i = 0; i <= s.length(); ++i) {
			f[i][0] = 1;
		}

		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 1; j <= t.length(); ++j) {
				if (i == j) {
					f[i][j] = s.charAt(i-1) == t.charAt(j-1)? f[i-1][j-1] : 0;
				} else if (i < j) {
					f[i][j] = 0;
				} else { //i > j
					if (s.charAt(i-1) == t.charAt(j-1)) {
						f[i][j] = f[i-1][j-1] + f[i-1][j];
					} else {
						f[i][j] = f[i-1][j];
					}
				}
			}
		}
		return f[s.length()][t.length()];
	}
}
