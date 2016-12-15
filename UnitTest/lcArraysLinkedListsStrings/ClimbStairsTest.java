package lcArraysLinkedListsStrings;

import lcArraysLinkedListsStrings.ClimbStairs;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClimbStairsTest {
	@Test(timeout = 10)
	public void test(){
		ClimbStairs myCS = new ClimbStairs(6);
		int[] fibo = {1,1,2,3,5,8,13};
		
		for(int i = 1; i <= 6; i ++){
			assertEquals("Fibo "+ i +" should be "+fibo[i],fibo[i],myCS.climbStairs(i));
		}
	}
}
