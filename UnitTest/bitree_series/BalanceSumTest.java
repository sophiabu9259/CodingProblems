package bitree_series;

import static org.junit.Assert.*;

import org.junit.Test;

public class BalanceSumTest {
	
	BalanceSum o = new BalanceSum();
	
	@Test
	public void testFindPivot1() {
		int[] arr = {
			1
		};
		
		assertEquals (0, o.findPivot(arr));
	}
	
	@Test
	public void testFindPivot2() {
		int[] arr = {
				Integer.MAX_VALUE, 0
		};
		
		assertEquals (0, o.findPivot(arr));
	}
	
	@Test
	public void testFindPivot3() {
		int[] arr = {
				0, Integer.MIN_VALUE
		};
		
		assertEquals (1, o.findPivot(arr));
	}
	
	@Test
	public void testFindPivot4() {
		int[] arr = {0, 10, 11, -11, 9 , 9, -18};
		assertEquals (1, o.findPivot(arr));
	}
	
	@Test
	public void testFindPivot5() {
		int[] arr = {10, 1, -1, 11, -11, 9, -18, 9};
		
		assertEquals (0, o.findPivot(arr));
	}
	
	@Test
	public void testFindPivot6() {
		int[] arr = {1, -1, 11, -11, 9, 9, -18, 10};
		
		assertEquals (7, o.findPivot(arr));
	}
	
	@Test
	public void testFindPivot7() {
		int[] arr = {1, 2, 3, 4, 10, 10};
		
		assertEquals (4, o.findPivot(arr));
	}

}
