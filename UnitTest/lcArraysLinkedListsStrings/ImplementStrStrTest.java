package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lcArraysLinkedListsStrings.ImplementStrStr;

public class ImplementStrStrTest {
	
	ImplementStrStr myISS = new ImplementStrStr();

	@Test
	public void test() {
		String input = "awefwaf3242";
		String sub = "fwaf3";
		assertEquals("match on 3",3,myISS.strStr(input, sub));
	}
	
	@Test
	public void test1() {
		String input = "";
		String sub = "fwaf3";
		assertEquals("haystack null", -1,myISS.strStr(input, sub));
	}
	
	@Test
	public void test2() {
		String input = "";
		String sub = "";
		assertEquals("both null", 0, myISS.strStr(input, sub));
	}
	
	@Test
	public void test3() {
		String input = "1";
		String sub = "";
		assertEquals("needle null", -1, myISS.strStr(input, sub));
	}
	
	@Test
	public void test4() {
		String input = "1";
		String sub = "1";
		assertEquals("matched on 0", 0,myISS.strStr(input, sub));
	}
	
	@Test
	public void test5() {
		String input = "awfeawifehiawf";
		String sub = "fehiawf0";
		assertEquals("Partial matched but needle exceeded", -1,myISS.strStr(input, sub));
	}
	
	@Test
	public void test6() {
		String input = "awfeawifehiawf";
		String sub = "awfeawifehiawf";
		assertEquals("full match", 0,myISS.strStr(input, sub));
	}

	@Test
	public void test7() {
		String input = "awfeawifehiawf";
		String sub = "eawi";
		assertEquals("partial match", 3,myISS.strStr(input, sub));
	}
	
}
