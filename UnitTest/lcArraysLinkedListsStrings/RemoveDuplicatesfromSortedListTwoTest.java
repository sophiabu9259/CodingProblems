package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;

import basicstructures.ListNode;
import lcArraysLinkedListsStrings.RemoveDuplicatesfromSortedListTwo;

import org.junit.Test;

public class RemoveDuplicatesfromSortedListTwoTest {

	RemoveDuplicatesfromSortedListTwo myRDFSLT = new RemoveDuplicatesfromSortedListTwo();
	
	@Test
	public void test() {
		ListNode testee = ListNode.newList(1,1,1,2,3,3,4,5);
		ListNode result = ListNode.newList(2,4,5);
		ListNode cc = myRDFSLT.removeDuplicatesTwo(testee);
		assertTrue("Delete Dups",ListNode.equals(result, cc));
	}

}
