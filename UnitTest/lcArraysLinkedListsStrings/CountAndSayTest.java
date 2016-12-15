package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import lcArraysLinkedListsStrings.CountAndSay;
import org.junit.Test;

public class CountAndSayTest {
	
	CountAndSay myCAS = new CountAndSay();

	@Test
	public void test() {
		assertEquals("1",myCAS.countAndSay(1));
		assertEquals("11", myCAS.countAndSay(2));
		assertEquals("21", myCAS.countAndSay(3));
		assertEquals("1211",myCAS.countAndSay(4));
		assertEquals("111221",myCAS.countAndSay(5));
		
	}

}
