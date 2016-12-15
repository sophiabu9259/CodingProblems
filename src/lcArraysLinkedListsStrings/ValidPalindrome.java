package lcArraysLinkedListsStrings;

public class ValidPalindrome {
	public boolean isPalindrome (String input) {
		if (input == null) {
			return true;
		}
		
		int lo = 0;
		int hi = input.length()-1;
		
		while (lo < hi) {
			if (!Character.isLetterOrDigit (input.charAt(lo))) {
				lo ++;
			} else if (!Character.isLetterOrDigit (input.charAt(hi))) {
				hi --;
			} else if (Character.toUpperCase(input.charAt(lo)) != Character.toUpperCase(input.charAt(hi))) {
					return false;
			} else {
			    lo++;
				hi--;
			}
		}
		
		return true;
	}
}
