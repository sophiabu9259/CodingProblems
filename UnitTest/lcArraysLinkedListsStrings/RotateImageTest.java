package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertEquals;
import lcArraysLinkedListsStrings.RotateImage;

import org.junit.Test;

public class RotateImageTest {
	RotateImage ri = new RotateImage();

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		int[][] testMatrix = {{1,2},
							  {3,4}};
		int[][] resultMatrix =  {{3,1},
								 {4,2}};
		ri.rotate(testMatrix);
		assertEquals("Rotate a 2x2 matrix",resultMatrix,testMatrix);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test2() {
		int[][] testMatrix = {{1,2,3},
							  {4,5,6},
							  {7,8,9}};
		int[][] resultMatrix =  {{7,4,1},
								 {8,5,2},
								 {9,6,3}};
		ri.rotate(testMatrix);
		assertEquals("Rotate a 3x3 matrix",resultMatrix,testMatrix);
	}
}


