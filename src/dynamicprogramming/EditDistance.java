package dynamicprogramming;
/**
 * dp[i][j] indicates from word1.sub(0,i+1) to word2.sub(0,j+1). dp[i][j] could have relation
 * with:
 * case 1: [0,i] transform to [0,j-1] then add w2[j] (insertion)
 * case 2: [0,i-1] transform to [0,j], then delete w1[i] (deletion)
 * case 3: [0,i-1] transform to [0, j - 1], then replace w1[i] with w2[j] (replacement)
 * minimum edit distance is the min value of these 3 cases.
 * @author Xuechao
 *
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for (int i = 0; i <= word1.length(); ++i) { // notice <=. 
			dp[i][0] = i;
		}

		for (int j = 0; j <= word2.length(); ++j) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= word1.length(); ++i) {
			for (int j = 1; j <= word2.length(); ++j) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) { //notice i and j stand for length.
					dp[i][j] = dp[i-1][j-1];
				} else {
					int replace = dp[i-1][j-1] + 1;
					int delete = dp[i-1][j] + 1;
					int insert = dp[i][j-1] + 1;
					int value = Math.min(replace, delete);
					dp[i][j] = Math.min(value, insert);
				}
			}
		}

		return dp[word1.length()][word2.length()];
	}
}
