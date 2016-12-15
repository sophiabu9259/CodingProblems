package word_xxxx_series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkBreak {
	public static boolean wordbreak (String input, Set<String> dict) {
		return backtracking (input, 0, dict);
	}
	
	private static boolean backtracking (String input, int start, Set<String> dict) {
		if (start == input.length()) {
			return true;
		} else {
			for (int i = start + 1; i <= input.length(); ++i) {
				System.out.println("Checking " + input.substring(start, i));
				if (dict.contains(input.substring(start, i))) {
					
					if (backtracking(input, i, dict)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Method 2: dp.
	 * if dp[i] == true, this marks all the string [0, i-1)] are able to be combined from dict.
	 * So i is a valid start-checking point. just make sure from i on, the folling strings can be combined from dictionary 
	 * runtime O(MN) M is input.length() N is dict.size()
	 * @param args
	 */
	
	public static boolean wordbreak2 (String input, Set<String> dict) {
		boolean[] check = new boolean[input.length() + 1];
		check[0] = true;
		
		for (int i = 0; i < check.length; ++i) {
			if (check[i]) {
				for (String word : dict) {
					if (i + word.length() <= input.length()) {
						if (input.substring(i, i + word.length()).equals(word)) {
							check[i + word.length()] = true;
						}
					}
				}
			}
		}
		
		return check[input.length()];
	}
	
	public static void main (String[] args) {
		Set<String> dict = new HashSet<>();
		String[] arr = {
				"leet", "code"
		};
		List<String> tempDict = new ArrayList<>(Arrays.asList(arr));
		dict.addAll(tempDict);
		String input = "leetcode";
		
		System.out.println("Test 1" + (wordbreak(input, dict) ? "passed" : "failed"));
	}
}
