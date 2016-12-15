package dynamicprogramming;

import java.util.Set;
/**
 * Notice i.
 * @author Xuechao
 *
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] check = new boolean[s.length()+1];
		check[0] = true; // i stands for length
		for (int i = 0; i < s.length(); ++i) {
		    if (!check[i]) continue;
		    
			for (String word: wordDict) {
				if (i + word.length() <=  s.length()) {
					String temp = s.substring(i , word.length() + i ); // x, x + len
					if (temp.equals (word) ) {
						check[i + word.length()] = true; // 
					}
				}
			}
		}

		return check[s.length()];

	}
}
