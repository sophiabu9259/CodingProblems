package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import java.util.Arrays;

import lcArraysLinkedListsStrings.PlusOne;

import org.junit.Test;

public class PlusOneTest {
	
	PlusOne PO = new PlusOne();
	
	@Test
	public void test() {
		int[] testInput = {9,9,9};
		int[] result = {1,0,0,0};
		assertTrue("999 to 1000",Arrays.equals(result, PO.plusOne(testInput)));							
	}
	
	@Test
	public void test2() {
		int[] testInput = {9,9,8};
		int[] result = {9,9,9};
		assertTrue("999 to 1000",Arrays.equals(result, PO.plusOne(testInput)));							
	}
	
	@Test
	public void test3() {
		int[] testInput = {1,0};
		int[] result = {1,1};
		assertTrue("999 to 1000",Arrays.equals(result, PO.plusOne(testInput)));							
	}

}
