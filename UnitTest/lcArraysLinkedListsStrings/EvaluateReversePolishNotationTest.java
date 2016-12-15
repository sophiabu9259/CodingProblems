package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import org.junit.Test;

import lcArraysLinkedListsStrings.EvaluateReversePolishNotation;

public class EvaluateReversePolishNotationTest {
	
	EvaluateReversePolishNotation myERPN = new EvaluateReversePolishNotation();
	@Test
	public void test() {
		String[] input = {
				"1","2","+","3","*"
		};
		
		assertEquals (" (1+2)*3 = 9", 9, myERPN.evalRPN(input));
	}
	
	@Test
	public void test_2() {
		String[] input = {
				"4", "-13", "5", "/", "+"
		};
		
		assertEquals("4 + (-13/5) = 2", 2, myERPN.evalRPN(input));
	}

}
