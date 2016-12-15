package dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniquePath2Test {
	UniquePath2 myUP2 = new UniquePath2();
	@Test
	public void testUniquePathsWithObstacles() {
		int[][] matrix = {
				{1,0,0},
				{0,0,0},
				{0,0,0}
		};
		
		assertEquals ("Entrance blocked", 0, myUP2.uniquePathsWithObstacles(matrix));
	}
	
	@Test
	public void testUniquePathsWithObstacles_1() {
		int[][] matrix = {
				{0,1,0},
				{0,0,0},
				{0,0,0}
		};
		
		assertEquals ("one block", 3, myUP2.uniquePathsWithObstacles(matrix));
	}
	
	@Test
	public void testUniquePathsWithObstacles_2() {
		int[][] matrix = {
				{0,0,0},
				{0,1,0},
				{0,0,1}
		};
		
		assertEquals ("Exit blocked", 0, myUP2.uniquePathsWithObstacles(matrix));
	}
	
	@Test
	public void testUniquePathsWithObstacles_3() {
		int[][] matrix = {
				{0,0,0},
				{0,1,1},
				{0,0,0}
		};
		
		assertEquals ("Only one way", 1, myUP2.uniquePathsWithObstacles(matrix));
	}
}
