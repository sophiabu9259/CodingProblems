package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import org.junit.Test;

import lcArraysLinkedListsStrings.LargestRectangleInHistogram;

public class LargestRectangleInHistogramTest {
	
	LargestRectangleInHistogram myLRIH = new LargestRectangleInHistogram();

	@Test
	public void test() {
		int[] test = {
				2,1,3,3,5,4,2,1,1,1,1,1,1
		};
		
		assertEquals(13,myLRIH.largestRectangleArea(test));
	}

}
