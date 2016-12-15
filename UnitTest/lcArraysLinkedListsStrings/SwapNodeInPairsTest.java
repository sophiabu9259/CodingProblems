package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;

import basicstructures.ListNode;
import lcArraysLinkedListsStrings.SwapNodeInPairs;
import org.junit.Test;

public class SwapNodeInPairsTest {
	
	SwapNodeInPairs mySNIP = new SwapNodeInPairs();

	@Test
	public void test() {
		ListNode testee = ListNode.newList(1,2,3,4,5);
		ListNode result = ListNode.newList(2,1,4,3,5);
		ListNode cc = mySNIP.swapPairs(testee);
		assertTrue("swap 5 ndoes",ListNode.equals(result, cc));
	}

}
