package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import org.junit.Test;

import lcArraysLinkedListsStrings.RegularExpressionMatching;

public class RegularExpressionMatchingTest {
	
	RegularExpressionMatching myREM = new RegularExpressionMatching();

	@Test
	public void test() {
		assertFalse(myREM.isMatch("bbbba", ".*a*a"));
	}

}
