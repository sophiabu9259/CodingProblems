package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertEquals;
import lcArraysLinkedListsStrings.StringToInteger;

import org.junit.Test;

public class StringToIntegerTest {
	
	StringToInteger mySTI = new StringToInteger();

	@Test
	public void test() {
		String test = "   +12345";
		int result = 12345;
		assertEquals("positive sign test",result,mySTI.stringToInteger(test));
	}
	
	@Test
	public void test2(){
		String test = " -12345";
		int result = -12345;
		assertEquals("negative sign test",result,mySTI.stringToInteger(test));
	}
	
	@Test
	public void test3(){
		String test = "";
		int result = 0;
		assertEquals("Empty String test",result,mySTI.stringToInteger(test));
	}
	
	@Test
	public void test4(){
		String test = null;
		int result = 0;
		assertEquals("Null string test",result,mySTI.stringToInteger(test));
	}
	
	@Test
	public void test5(){
		String test = "   aif fawf fawn 1231231";
		int result = 0;
		assertEquals("First sequence not integer sequence test",result,mySTI.stringToInteger(test));
	}
	
	@Test
	public void test6(){
		String test = "     -123414124oanoaiefjwowaijfw";
		int result = -123414124;
		assertEquals("Following by none digits test",result,mySTI.stringToInteger(test));
	}
	
	@Test
	public void test7(){
		String test = String.valueOf((long)Integer.MAX_VALUE + 50);
		int result = Integer.MAX_VALUE;
		assertEquals("Larger than max test",result,mySTI.stringToInteger(test));
	}
	
	@Test
	public void test8(){
		String test = String.valueOf((long) Integer.MIN_VALUE-50);
		int result = Integer.MIN_VALUE;
		assertEquals("Less than min test", result, mySTI.stringToInteger(test));
	}
	
	@Test
	public void test9(){
		String test = String.valueOf(Integer.MAX_VALUE);
		int result = Integer.MAX_VALUE;
		assertEquals("Max test",result,mySTI.stringToInteger(test));
	}
	
	@Test
	public void test_10(){
		String test = String.valueOf(Integer.MIN_VALUE);
		int result = Integer.MIN_VALUE;
		assertEquals("Min test", result, mySTI.stringToInteger(test));
	}
	
	@Test
	public void test_11(){
		String test = "-2147483649";
		int result = Integer.MIN_VALUE;
		assertEquals("Min test 2", result, mySTI.stringToInteger(test));
	}

}
