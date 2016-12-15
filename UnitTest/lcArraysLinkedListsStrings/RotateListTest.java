package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import basicstructures.ListNode;
import lcArraysLinkedListsStrings.RotateList;

public class RotateListTest {

	
	RotateList myRL = new RotateList();
	ListNode testee = ListNode.newList(1,2,3,4,5);
	ListNode result = ListNode.newList(4,5,1,2,3);
	ListNode cc;
	
	@Test
	public void test() {
		
		cc = myRL.rotate(testee, 2);
		assertTrue("Rotate 2 nodes to the right",ListNode.equals(result, cc));
		
	}
	
	@Test
	public void test2() {
		cc = myRL.rotate(testee, 0);
		assertTrue("Rotate 0 nodes to the right",ListNode.equals(testee, cc));
	}
	
	@Test
	public void test3() {
		cc = myRL.rotate(null, 1000);
		assertTrue("Rotate 0 nodes to the right",ListNode.equals(null, cc));
	}
	
	@Test
	public void test4() {
		cc = myRL.rotate(testee, 7);
		assertTrue("Rotate 7 nodes to the right",ListNode.equals(result, cc));
	}

}
