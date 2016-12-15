package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import org.junit.Test;

import lcArraysLinkedListsStrings.LongestCommonPrefix;

public class LongestCommonPrefxiTest {

	LongestCommonPrefix myLCP = new LongestCommonPrefix();
	
	@Test
	public void test_EmptyElement() {
		String[] inputs = {
				"",
				"a"
		};
		
		assertEquals("empty element", "", myLCP.findPrefix(inputs));
	}
	
	@Test
	public void test_EmptyInputs() {
		String[] inputs = {};
		assertEquals("empty input", "", myLCP.findPrefix(inputs));
	}
	
	@Test
	public void test_nullInput() {
		String[] inputs = null;
		assertEquals("Null inputs", "", myLCP.findPrefix(inputs));
	}
	
	@Test
	public void test_firstShortest() {
		String[] inputs = {
				"aas",
				"aasvvv",
				"aasvvvvv",
				"aass"
		};
		assertEquals("first shortest", "aas", myLCP.findPrefix(inputs));
	}
	
	@Test
	public void test_firstLongest() {
		String[] inputs = {
				"aasssssss",
				"aasss",
				"aas"
		};
		assertEquals("first longest", "aas", myLCP.findPrefix(inputs));
	}
	
	@Test
	public void test_totallyDiff() {
		String[] inputs = {
				"a",
				"b",
				"c"
		};
		assertEquals("totally different", "", myLCP.findPrefix(inputs));
	}

}
