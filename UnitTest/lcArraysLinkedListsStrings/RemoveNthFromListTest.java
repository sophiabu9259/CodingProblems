package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;

import basicstructures.ListNode;
import lcArraysLinkedListsStrings.RomoveNthFromList;

import org.junit.Test;

public class RemoveNthFromListTest {
	
	ListNode testee = ListNode.newList(1,2,3,4,5);
	ListNode result = ListNode.newList(1,2,3,5);
	ListNode cc;
	
	RomoveNthFromList myRNFL = new RomoveNthFromList();

	@Test
	public void test() {
		cc = myRNFL.removeNthFromEnd(testee, 2);
		assertTrue("remove 2 from end",ListNode.equals(result, cc));
	}
	
	@Test
	public void test2() {
		testee = ListNode.newList(1);
		result = null;
		
		cc = myRNFL.removeNthFromEnd(testee, 1);
		assertTrue("remove 2 from end",ListNode.equals(result, cc));
	}

}
