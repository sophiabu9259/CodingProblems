package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lcArraysLinkedListsStrings.AddBinary;

public class AddBinaryTest {

	AddBinary myAB = new AddBinary();
	
	@Test
	public void test() {
		String a = "111";
		String b = "1";
		assertEquals("111+1=1000","1000",myAB.addBinary(a, b));
	}
	
	@Test
	public void emptyTest() {
		String a = "";
		String b = "";
		assertEquals("nothing","",myAB.addBinary(a, b));
	}
	
	@Test
	public void nullTest() {
		String a = null;
		String b = null;
		assertEquals ("null",null, myAB.addBinary(a, b));
	}
	
	@Test
	public void singleNullTest () {
		String a = null;
		String b = "1111";
		assertEquals("a null return b", "1111", myAB.addBinary(a, b));
	}
	
	@Test
	public void addTest () {
		String a = "1010";
		String b = "1011";
		assertEquals("a null return b", "10101", myAB.addBinary(a, b));
	}

}
