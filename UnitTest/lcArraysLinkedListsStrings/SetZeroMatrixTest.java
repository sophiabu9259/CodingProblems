package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;
import lcArraysLinkedListsStrings.SetZeroMatrix;

import org.junit.Test;

public class SetZeroMatrixTest {
	
	SetZeroMatrix mySZM = new SetZeroMatrix();

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		int[][] matrix = {{0,2,3},
						  {5,6,1},
						  {2,0,3}};
		int[][] result = {{0,0,0},
				  		  {0,0,1},
				          {0,0,0}};
		mySZM.setZeroes(matrix);
		assertEquals(result,matrix);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test2() {
		int[][] matrix = {{1,2,3},
						  {5,0,1},
						  {2,1,3}};
		int[][] result = {{1,0,3},
				  		  {0,0,0},
				          {2,0,3}};
		mySZM.setZeroes(matrix);
		assertEquals(result,matrix);
	}
}


