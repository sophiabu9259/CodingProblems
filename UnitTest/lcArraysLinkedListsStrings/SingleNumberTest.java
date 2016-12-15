package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertEquals;

import lcArraysLinkedListsStrings.SingleNumber;

import org.junit.Test;

public class SingleNumberTest {
	
	SingleNumber mySN = new SingleNumber();
	
	@Test
	public void test_singleNumer() {
		int[] input = new int[]{
				1, 2, 3, 4, 4, 3, 2
		};
		
		assertEquals(1, mySN.singleNumber(input));
	}

}
