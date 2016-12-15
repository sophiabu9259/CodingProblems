package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;

import lcArraysLinkedListsStrings.RemoveDuplicatesFromSortedList;
import basicstructures.ListNode;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListTest {
	
	RemoveDuplicatesFromSortedList myRDFS = new RemoveDuplicatesFromSortedList();
	
	@Test
	public void test() {
		ListNode testHead = ListNode.newList(1,2,2,3,4,5,5,6);
		ListNode resultHead = ListNode.newList(1,2,3,4,5,6);
		
		ListNode cc = myRDFS.deleteDuplicates(testHead);

		assertTrue(ListNode.equals(resultHead, cc));
	}

}
