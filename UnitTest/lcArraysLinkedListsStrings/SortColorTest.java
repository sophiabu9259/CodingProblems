package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import lcArraysLinkedListsStrings.SortColors;

public class SortColorTest{
	
	SortColors mySC = new SortColors();

	@Test
	public void test() {
		int[] test = {
				2,0,1,0,1,1,2,2,0
		};
		
		int[] result = {
				0,0,0,1,1,1,2,2,2
		};
		
		mySC.sortColors(test);
		assertTrue(Arrays.equals(result, test));
	}
	
	@Test
	public void testOnePass() {
		int[] test = {
				2,0,1,0,1,1,2,2,0
		};
		
		int[] result = {
				0,0,0,1,1,1,2,2,2
		};
		
		mySC.sortColorsOnePass(test);
		assertTrue(Arrays.equals(result, test));
	}

}
