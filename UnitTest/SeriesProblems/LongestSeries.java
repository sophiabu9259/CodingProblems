package SeriesProblems;

import java.util.HashSet;
import java.util.Set;

public class LongestSeries {
	class LongestSubstringWithoutRepeatingCharacters {
		int findLongestNonRepeat (String input) {
			Set<Character> sub = new HashSet<>();
			int max = sub.size();
			int lastStart = 0;
			
			for (int i = 0; i < input.length(); i++) {
				if (!sub.contains(input.charAt(i))) {
					sub.add(input.charAt(i));
					max = Math.max(max, sub.size());
				} else {
					while (input.charAt(lastStart) != input.charAt(i)) {
						sub.remove(input.charAt(lastStart++));
					}
					//sub.add(input.charAt(i)); wrong. now last start is still at the last duplciate char. need ++. you can remove past and add new one. BUt its the same.
					lastStart++;
		
				}
			}
			return max;
		}
	}
	
	class LongestPalindromeSubstring {
		int findLongestPS (String input) {
			//TODO
			return 0;
		}
	}
}
