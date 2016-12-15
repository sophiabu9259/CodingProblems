package lcArraysLinkedListsStrings;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        int result = 0;
        for (String e : s.split(" ")) {
            result = e.length();
        }
        return result;
    }
}
