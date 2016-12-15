package lcArraysLinkedListsStrings;
/**
 * Use first string as base. Use a helper to determine index and char valid(length in each e, same char in every e). Stringbuilder to append.
 * Remember to break when helper returns false: "bca" and "aaa"
 * @author Xuechao
 *
 */
public class LongestCommonPrefix {
	public String findPrefix (String[] inputs) {
		if (inputs == null) {
			return "";
		}
		if (inputs.length == 0) {
			return "";
		}
		StringBuilder myStrB = new StringBuilder();
		for (int i = 0; i < inputs[0].length(); i++){
			if (helper (i, inputs)) {
				myStrB.append(inputs[0].charAt(i));
			} else {
				break;
			}
		}
		return myStrB.toString();
	}
	
	public boolean helper ( int i, String[] inputs) {
		for (String e: inputs) {
			if ( i >= e.length()) {
				return false;
			}
			
			if ( e.charAt(i) != inputs[0].charAt(i)) {
				return false;
			}
		}
		
		return true;	
	}
}
