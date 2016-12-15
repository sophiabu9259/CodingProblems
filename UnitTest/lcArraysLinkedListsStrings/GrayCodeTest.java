package lcArraysLinkedListsStrings;
import lcArraysLinkedListsStrings.GrayCode;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GrayCodeTest {
	GrayCode myGC = new GrayCode();
	
	@Test
	public void test() {
		
		Integer[] resultOfTwo = new Integer[]{0,1,3,2};
		List<Integer> lr2 = Arrays.asList(resultOfTwo);
		assertEquals("Test N = 2",lr2,myGC.grayCode(2));		
	}
	
	@Test
	public void test2(){
		Integer[] resultOfThree = new Integer[]{0,1,3,2,6,7,5,4};
		List<Integer> lr3 = Arrays.asList(resultOfThree);
		assertEquals("Test N = 3",lr3,myGC.grayCode(3));
	}

}
