package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lcArraysLinkedListsStrings.ValidPalindrome;

public class ValidPalindromeTest {

	@Test
	public void test() {
		ValidPalindrome myVP = new ValidPalindrome ();
		String input = "hey, a?a  --y...e?h";
		assertTrue(myVP.isPalindrome(input));
	}

}
