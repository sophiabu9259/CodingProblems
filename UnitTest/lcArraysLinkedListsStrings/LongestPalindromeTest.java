package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import lcArraysLinkedListsStrings.LongestPalindrome;

public class LongestPalindromeTest {
	
	LongestPalindrome myLP = new LongestPalindrome();

	@Test
	public void test() {
		String test = "tygcabacnm";
		String result = "cabac";
		assertEquals(result,myLP.longestPalinDrome(test));
	}

}
