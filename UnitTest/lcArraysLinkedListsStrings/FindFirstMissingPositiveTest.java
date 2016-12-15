package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import org.junit.Test;

import lcArraysLinkedListsStrings.FindFirstMissingPositive;

public class FindFirstMissingPositiveTest {
	
	FindFirstMissingPositive myFFMP = new FindFirstMissingPositive();
	@Test
	public void test() {
		int[] input = {1,4,2,3,-1,5,8,9,7};
		assertEquals("missing 6", 6, myFFMP.findFirstMissingPositive(input));
	}
	
	@Test
	public void test2() {
		int[] input = {-1};
		assertEquals("missing 1", 1, myFFMP.findFirstMissingPositive(input));
	}
	
	@Test
	public void test3() {
		int[] input = {1,10,3};
		assertEquals("missing 2", 2, myFFMP.findFirstMissingPositive(input));
	}
	
	@Test
	public void test4() {
		int[] input = {3,4,-1,1};
		assertEquals("missing 2", 2, myFFMP.findFirstMissingPositive(input));
	}
	
	@Test
	public void test_double1() {
		int[] input = {1,1};
		assertEquals("missing 2", 2, myFFMP.findFirstMissingPositive(input));
	}
	
	@Test
	public void test_double2() {
		int[] input = {2,2};
		assertEquals("missing 1", 1, myFFMP.findFirstMissingPositive(input));
	}

}
