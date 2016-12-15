package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * ABORTED: See the one under package wordxxxxseries
 * draw a table of dpIndex, charIndex, char and dp (list).
 * use List<String>[] as dp array instead of boolean. From end to start, for each word in 
 * dp[i], its next word is in dp[i-word.len]. until i = 0.
 * @author Xuechao
 *
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		@SuppressWarnings("unchecked")
		List<String>[] dp = new ArrayList[s.length()+1];
		dp[0] = new ArrayList<>();// i is length, dp[i] means [0, i-1] is in dict. When we are at i,
		// dp[i] means index[0,i-1] safe, just check index[i, i + len-1] safe or not. If so mark dp[i+len]
		// as safe,

		for (int i = 0; i < s.length(); i++) {
			if (dp[i] == null) {
				continue;
			}

			for (String word : wordDict) {
				if (word.length() + i <= s.length()) {
					String temp = s.substring(i, i+word.length());
					if (temp.equals(word)) {
						if (dp[i + word.length()] == null) {
							dp[i+word.length()] = new ArrayList<>();
						}
						dp[i+word.length()].add(temp);
					}
				}
			}
		}

		List<String> ret = new ArrayList<>();
		if (dp[s.length()] != null) {
			dfs (dp, new StringBuilder(), s.length(), ret);
		}
		return ret;
	}

	void dfs (List<String>[] dp, StringBuilder temp, int end, List<String> ret) {
		if (end == 0) {
			char ch = temp.charAt(temp.length()-1);
			temp.deleteCharAt(temp.length()-1);
			ret.add(temp.toString());
			temp.append(ch);
		} else {
			for (String s : dp[end]) {
				temp.insert(0, " ");
				temp.insert(0, s);
				dfs (dp, temp, end-s.length(), ret);
				temp.delete(0, s.length()+1);
			}
		}
	}
}
