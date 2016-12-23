package bfs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindMinimumPathTest {
	
	FindMinimumPath o = new FindMinimumPath();
	
	@Test
	public void testPathfinding_0() {
		int[][] matrix = {
				{1, 0, 1},
				{1, 1, 1},
				{1, 0, 1}
		};
		
		List<int[]> resExp = new ArrayList<>();
		int[][] resArr = {
				{0, 0}, {1, 1}, {2, 2}
		};
		for (int[] arr : resArr) {
			resExp.add(arr);
		}
		

		List<int[]> test = o.pathfinding(matrix, new int[] {0, 0}, new int[] {2, 2});
		//assertEquals ("Noraml test", resExp, test);
		
		for (int[] e : test) {
			System.out.print(Arrays.toString(e) + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void testPathfinding_1 () {
		int[][] matrix = {
				{1, 1, 1, 0, 1, 1, 1},
				{1, 0, 1, 0, 1, 0, 1},
				{1, 0, 1, 1, 1, 0, 1}
		};
		
		List<int[]> test = o.pathfinding(matrix, new int[] {0, 0}, new int[] {2, 6});
		for (int[] e : test) {
			System.out.print(Arrays.toString(e) + ",");
		}
		System.out.println();
	}

}
