package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;

import org.junit.Test;

import basicstructures.ListNode;
import lcArraysLinkedListsStrings.MergeKLists;

public class MergeKListsTest {
	MergeKLists myMKL = new MergeKLists();
	@Test (timeout = 10000)
	public void test() {
		ListNode test1 = ListNode.newList(1,4,7,10);
		ListNode test2 = ListNode.newList(2,5,8,11);
		ListNode test3 = ListNode.newList(3,6,9,12);
		ListNode result = ListNode.newList(1,2,3,4,5,6,7,8,9,10,11,12);
		ListNode[] lists = {test1,test2,test3};
		
		assertTrue ("Merge 3 lists", ListNode.equals(result, myMKL.mergeKLists(lists)));
		
	}
	
	@Test (timeout = 10000)
	public void test_heap() {
		ListNode test1 = ListNode.newList(1,4,7,10);
		ListNode test2 = ListNode.newList(2,5,8,11);
		ListNode test3 = ListNode.newList(3,6,9,12);
		ListNode result = ListNode.newList(1,2,3,4,5,6,7,8,9,10,11,12);
		ListNode[] lists = {test1,test2,test3};
		
		assertTrue ("Merge 3 lists", ListNode.equals(result, myMKL.mergeKListsHeap(lists)));
	}

}
