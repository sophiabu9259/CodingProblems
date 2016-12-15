package backtracking;
import java.util.ArrayList;
import java.util.List;
public class LetterCombinationsOfAPhoneNumber {
	private static final String[] mappings = {
			"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
	};
	public List<String> letterCombinations (String digits) {
		List<String> ret = new ArrayList<>();
		if (digits.length() == 0) return ret;
		backtracking(ret, new StringBuilder(), digits, 0);
		return ret;
	}
	
	private void backtracking ( List<String> ret, StringBuilder temp, String digits, int index) {
		if (index == digits.length()) {
			ret.add(temp.toString());
		} else {
			char[] numChars = mappings[digits.charAt(index) - '0'].toCharArray();
			for (char c : numChars) {
				temp.append(c);
				backtracking(ret,temp,digits,index+1);
				temp.deleteCharAt(temp.length()-1);
			}
		}
	}
}
