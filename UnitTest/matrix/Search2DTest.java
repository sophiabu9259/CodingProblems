package matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class Search2DTest {
	
	Search2D myS2 = new Search2D();
	
	@Test
	public void testSearchMatrix() {
		int[][] input = {
				{1,3,5,7},
				{10,13,16,19},
				{25,27,29,31},
				{41,44,46,49}
		};
		
		assertFalse ("Search for 0", myS2.searchMatrix(input, 0));
		assertTrue ("Search for 1", myS2.searchMatrix(input, 1));
		assertTrue ("Search for 27", myS2.searchMatrix(input, 27));
		assertTrue("Search for 49", myS2.searchMatrix(input, 49));
		assertFalse ("Search for 55", myS2.searchMatrix(input, 55));
		
	}

}
