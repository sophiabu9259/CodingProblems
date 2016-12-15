package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import basicstructures.ListNode;
import lcArraysLinkedListsStrings.ReverseGroupK;

public class ReverseKTest {
	
	ReverseGroupK myRGK = new ReverseGroupK();

	@Test
	public void test() {
		ListNode testee = ListNode.newList(1,2,3,4,5);
		ListNode result = ListNode.newList(3,2,1,4,5);
		ListNode cc = myRGK.reverseK(testee, 3);
		assertTrue("reverse 3",ListNode.equals(result, cc));
	}
	
	@Test
	public void test2() {
		ListNode testee = ListNode.newList(1,2,3,4,5);
		ListNode result = ListNode.newList(4,3,2,1,5);
		ListNode cc = myRGK.reverseK(testee, 4);
		assertTrue("reverse 4",ListNode.equals(result, cc));
	}

}
