package dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class BurstBalloonsTest {
	
	BurstBalloons o = new BurstBalloons();
	
	@Test
	public void test() {
		int[] test1 = {3, 1, 5, 8};
		assertEquals ("sample case 3,1,5,8", 167, o.maxCoins(test1));
	}
	
	@Test
	public void test2() {
		int[] test1 = {3, 1, 5};
		assertEquals ("sample case 3,1,5,8", 35, o.maxCoins(test1));
	}
	
	@Test
	public void test3() {
		int[] test1 = {3, 1};
		assertEquals ("sample case 3,1", 6, o.maxCoins(test1));
	}
	
	@Test
	public void test4() {
		int[] test1 = {3};
		assertEquals ("sample case 3", 3, o.maxCoins(test1));
	}

}
