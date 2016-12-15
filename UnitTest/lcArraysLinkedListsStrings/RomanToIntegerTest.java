package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import org.junit.Test;

import lcArraysLinkedListsStrings.RomanToInteger;

public class RomanToIntegerTest {
	RomanToInteger myRTI = new RomanToInteger();
	@Test
	public void test_Empty() {
		String temp = "";
		int result = 0;
		assertEquals("empty input", result, myRTI.romanToInteger(temp));
	}
	
	@Test
	public void test_Single() {
		String test = "M";
		int result = 1000;
		assertEquals("test M", result, myRTI.romanToInteger(test));
	}
	
	@Test
	public void test_twoMinus() {
		String test = "CM";
		int result = 900;
		assertEquals("test CM", result, myRTI.romanToInteger(test));
	}
	
	@Test
	public void test_long() {
		String test = "MCMIX";
		int result = 1909;
		assertEquals("test MCMIX", result, myRTI.romanToInteger(test));
	}
	

}
