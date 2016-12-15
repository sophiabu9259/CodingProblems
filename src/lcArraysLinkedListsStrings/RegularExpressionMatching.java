package lcArraysLinkedListsStrings;
/**
 * First char in pattern only can be 'a-z' or '.'  USE 1-on-1 match (non-* cases), or skipping match (* cases)
 * @author Xuechao
 *
 */
public class RegularExpressionMatching {
	public boolean isMatch (String input, String pattern) {
		if (pattern == null) {
			return input == null;
		}
		
		if (pattern.length() == 0) {
			return input.length() == 0;
		}
		
		if (pattern.length() == 1 || pattern.charAt(1) != '*') {
			if (input.length() == 0) {
				return false;
			}
			if (input.charAt(0) != pattern.charAt(0)) {
				if (pattern.charAt(0) != '.') {
					return false;
				}
			}
			
			return isMatch (input.substring(1), pattern.substring(1));
		}
		
		String temp = input;
		// if temp is "", we throw it to pattern substring(2) to match
		// else , match first char. Matched -> dont move input. Even if temp[0] matched the pattern, 
		// it might be part of the --xxx pattern (x*xxx without x*).
		//Not match -> * means 0 appearance, dont move input, move pattern.
		while ( temp.length() > 0 && (temp.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.')) {
			if (isMatch(temp, pattern.substring(2))) { // dont use temp.substring(1): even if temp[0] matches the x* pattern.
				return true;
			}
			temp = temp.substring(1);
		}
		return isMatch(temp, pattern.substring(2));
		
		
	}
}
