package backtracking;

import java.util.ArrayList;
import java.util.List;
/**
 * draw a tree of partitioning. Traverse from index'start' to the end to get every possible palindrome with index 'start' as an element of level.
 * @author Xuechao
 *
 */
public class PalindromePartitioning {
	public List<List<String>> partition (String s) {
		List<List<String>> ret = new ArrayList<>();
		if (s.length() == 0l) return ret;
		backtracking (ret, new ArrayList<String>(), s, 0);
		return ret;
	}
	
	private void backtracking (List<List<String>> ret, List<String> temp, String s, int start) {
		if (start == s.length()) {
			ret.add(new ArrayList<String>(temp));
		} else {
			for (int i = start; i < s.length(); i++) {
				if (isPalindrome(s,start,i)) {
					temp.add(s.substring(start, i+1));
					backtracking (ret, temp, s, i+1);
					temp.remove(temp.size()-1);
				}
			}
		}
	}
	
	private boolean isPalindrome (String s, int start, int end){
		if ( start == end ) return true;
		while ( start < end) {
			if (s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}
