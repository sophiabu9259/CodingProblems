package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertEquals;

import lcArraysLinkedListsStrings.SingleNumberTwo;

import org.junit.Test;

public class SingleNumberTwoTest {
	
	SingleNumberTwo mySNT = new SingleNumberTwo();
	
	@Test
	public void test() {
		int[] testInput = new int[]{
				1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9
		};
		
		assertEquals(0,mySNT.singleNumberTwo(testInput));
	}

}
