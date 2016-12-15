package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertTrue;

import lcArraysLinkedListsStrings.PartitionList;

import org.junit.Test;

import basicstructures.ListNode;

/**
 * passed on LeetCode
 * @author Xuechao
 *
 */
public class PartitionListTest {

	PartitionList myPL = new PartitionList();
	
	@Test
	public void test() {
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(3);
		ListNode test3 = new ListNode(4);
		ListNode test4 = new ListNode(2);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = null;
		
		ListNode result1 = new ListNode(1);
		ListNode result2 = new ListNode(2);
		ListNode result3 = new ListNode(3);
		ListNode result4 = new ListNode(4);
		
		result1.next = result2;
		result2.next = result3;
		result3.next = result4;
		result4.next = null;
		
		assertTrue(ListNode.equals(result1, myPL.partition(test1, 3)));
	}
	
	@Test
	public void test2() {
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(5);
		ListNode test3 = new ListNode(4);
		ListNode test4 = new ListNode(6);
		ListNode test5 = new ListNode(7);
		ListNode test6 = new ListNode(4);
		ListNode test7 = new ListNode(2);
		ListNode test8 = new ListNode(3);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = test5;
		test5.next = test6;
		test6.next = test7;
		test7.next = test8;
		test8.next = null;
		
		ListNode result1 = new ListNode(1);
		ListNode result2 = new ListNode(2);
		ListNode result3 = new ListNode(3);
		ListNode result4 = new ListNode(5);
		ListNode result5 = new ListNode(4);
		ListNode result6 = new ListNode(6);
		ListNode result7 = new ListNode(7);
		ListNode result8 = new ListNode(4);
		
		result1.next = result2;
		result2.next = result3;
		result3.next = result4;
		result4.next = result5;
		result5.next = result6;
		result6.next = result7;
		result7.next = result8;
		result8.next = null;
		
		assertTrue(ListNode.equals(result1, myPL.partition(test1, 4)));
	}

}
