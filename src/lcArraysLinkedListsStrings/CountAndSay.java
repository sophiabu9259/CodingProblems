package lcArraysLinkedListsStrings;

public class CountAndSay {
	public String countAndSay (int n) {
		String s = "1";
		for (int i = 1; i < n; i++){
			s = helper(s);
		}
		return s;
	}
	
	public String helper (String input) {
		StringBuilder myStrB = new StringBuilder();
		if (input.length() == 0) {
			return "";
		}
		if (input.length() == 1) {
			myStrB.append(1);
			myStrB.append(input.charAt(0));
			return myStrB.toString();
		}
		
		int count = 1;
		for (int i = 0; i < input.length()-1; i++){
			if (input.charAt(i) == input.charAt(i+1)) {
				count ++;
			} else {
				myStrB.append(count);
				myStrB.append(input.charAt(i));
				count = 1;
			}
		}
	
		myStrB.append(count);
		myStrB.append(input.charAt(input.length()-1));
		return myStrB.toString();
		
	}
}

