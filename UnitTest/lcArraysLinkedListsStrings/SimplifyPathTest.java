package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lcArraysLinkedListsStrings.SimplifyPath;

public class SimplifyPathTest {
	
	SimplifyPath mySP = new SimplifyPath();

	@Test
	public void test_OverFlow() {
		String input = "/../..//////..///////..";
		String result = "/";
		assertEquals("Overflow test", result, mySP.simplifyPath(input));
	}
	
	@Test
	public void test_redundantSlash() {
		String input = "/a/b//c/..//";
		String result = "/a/b";
		assertEquals("redundant slash", result, mySP.simplifyPath(input));
	}

}
