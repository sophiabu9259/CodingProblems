package lcArraysLinkedListsStrings;

import basicstructures.ListNode;

/**
 * Create two dummy. One for less ones. One for values >= x. Then combine them together.
 * @author Xuechao
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode leftdummy = new ListNode(-1);
        ListNode rightdummy = new ListNode(-1);
        ListNode leftRunner = leftdummy;
        ListNode rightRunner = rightdummy;
        
        ListNode cur = head;
        while (cur != null) {
        	if (cur.val < x) {
        		leftRunner.next = cur;
        		leftRunner = leftRunner.next;
        		cur = cur.next;
        	} else {
        		rightRunner.next = cur;
        		rightRunner = rightRunner.next;
        		cur = cur.next;
        	}
        }
        
        leftRunner.next = rightdummy.next;
        rightRunner.next = null;
        return leftdummy;
		
    }
}
