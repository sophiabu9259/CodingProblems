package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;

import basicstructures.ListNode;
import lcArraysLinkedListsStrings.ReorderList;

import org.junit.Test;

public class ReorderListTest {
	
	ReorderList myRL = new ReorderList();

	@Test
	public void test() {
		ListNode testee = ListNode.newList(1,2,3,4,5);
		ListNode result = ListNode.newList(1,5,2,4,3);
		ListNode cc = myRL.reorder(testee);
		assertTrue("Test 5", ListNode.equals(result, cc));
	}
	
	@Test
	public void test2() {
		ListNode testee = ListNode.newList(1,2,3);
		ListNode result = ListNode.newList(1,3,2);
		ListNode cc = myRL.reorder(testee);
		assertTrue("Test 3", ListNode.equals(result, cc));
	}
	
	@Test
	public void test3() {
		ListNode testee = ListNode.newList(1,2,3,4,5,6,7);
		ListNode result = ListNode.newList(1,7,2,6,3,5,4);
		ListNode cc = myRL.reorder(testee);
		assertTrue("Test 7", ListNode.equals(result, cc));
	}
	
	@Test
	public void test4() {
		ListNode testee = ListNode.newList(1);
		ListNode result = ListNode.newList(1);
		ListNode cc = myRL.reorder(testee);
		assertTrue("Test 1", ListNode.equals(result, cc));
	}

}
