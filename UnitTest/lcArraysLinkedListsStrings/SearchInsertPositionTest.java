package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInsertPositionTest {
	
	SearchInsertPosition mySIP = new SearchInsertPosition();
	int[] input = {
			1,3,4,5,6,9
	};
	@Test
	public void testSearchInsertPosition_1() {
		assertEquals ("search for 0", 0, mySIP.searchInsertPosition(input, 0));

	}
	
	@Test
	public void testSearchInsertPosition_2() {

		assertEquals ("search for 1", 0, mySIP.searchInsertPosition(input, 1));

	}
	
	@Test
	public void testSearchInsertPosition_3() {

		assertEquals ("search for 2", 1, mySIP.searchInsertPosition(input, 2));

	}
	
	@Test
	public void testSearchInsertPosition_4() {

		assertEquals ("search for 10", 6, mySIP.searchInsertPosition(input, 10));
	}
}
