package lcArraysLinkedListsStrings;
import static org.junit.Assert.*;

import org.junit.Test;

import basicstructures.ListNode;
import lcArraysLinkedListsStrings.InsertionList;

public class InsertionListTest {
	
	InsertionList myIL = new InsertionList();

	@Test
	public void test() {
		ListNode test = ListNode.newList(1,5,3,4,6,2);
		ListNode result = ListNode.newList(1,2,3,4,5,6);
		assertTrue(ListNode.equals(result,myIL.insertionSortList(test)));
	}

}
