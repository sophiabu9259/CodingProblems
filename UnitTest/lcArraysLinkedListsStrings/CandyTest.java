package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;
import lcArraysLinkedListsStrings.Candy;

import org.junit.Test;

public class CandyTest {
	Candy myC = new Candy();
	@Test
	public void test() {
		int[] ratings = {0,1,2,3,2,1};	
		assertEquals(13,myC.candy(ratings));
	}
	
	@Test
	public void test2(){
		int[] ratings = {1,1,1,1,1};
		assertEquals(5,myC.candy(ratings));
	}
	
	@Test
	public void test3(){
		int[] ratings = {1,3,2,4,1};
		assertEquals(7,myC.candy(ratings));
	}

}
