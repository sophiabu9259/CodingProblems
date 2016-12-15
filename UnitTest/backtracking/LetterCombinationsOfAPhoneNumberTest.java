package backtracking;

import java.util.List;

import org.junit.Test;

public class LetterCombinationsOfAPhoneNumberTest {
	
	LetterCombinationsOfAPhoneNumber myLCOAPN = new LetterCombinationsOfAPhoneNumber();
	
	@Test
	public void testLetterCombinations() {
		String digits = "23";
		List<String> ret = myLCOAPN.letterCombinations(digits);
		for (String s : ret) {
			System.out.print(s + ", ");
		}
	}

}
