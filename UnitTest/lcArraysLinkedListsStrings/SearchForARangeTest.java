package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import lcArraysLinkedListsStrings.SearchForARange;

public class SearchForARangeTest {
	
	SearchForARange mySFAR = new SearchForARange();
	@Test
	public void testSearchRange() {
		int[][] testInputs = {
				{},
				null,
				{8},
				{7},
				{1,2,3,4,5,6,7,8,8,8,8,9}
		};
		
		int[][] testResults = {
				{-1,-1},
				{-1,-1},
				{0,0},
				{-1,-1},
				{7,10}
		};
		
		for (int i = 0; i < 5; i++) {
			assertTrue ("test "+i+": ", Arrays.equals(testResults[i],mySFAR.searchRange(testInputs[i], 8)));
		}
	}

}
