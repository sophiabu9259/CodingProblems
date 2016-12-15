package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;
import lcArraysLinkedListsStrings.ReverseLinkedListTwo;

import org.junit.Test;

import basicstructures.ListNode;

public class ReverseLinkedListTwoTest {
	
	ReverseLinkedListTwo myRLLT = new ReverseLinkedListTwo();
	@Test
	public void test() {
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(4);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = null;
		
		ListNode result1 = new ListNode(1);
		ListNode result2 = new ListNode(2);
		ListNode result3 = new ListNode(3);
		ListNode result4 = new ListNode(4);
		
		result1.next = result4;
		result4.next = result3;
		result3.next = result2;
		result2.next = null;
		
		assertTrue(ListNode.equals(result1, myRLLT.reverseLinkedList(test1, 2, 4)));
	}

}
