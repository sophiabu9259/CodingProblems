package lcArraysLinkedListsStrings;

import basicstructures.ListNode;

public class InsertionList {
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode runner = head;
        
        while ( runner.next != null ) {
        	if (runner.next.val < runner.val) {
        		ListNode runner2  = dummy;
        		while (runner2.next.val < runner.next.val) {
        			runner2 = runner2.next;
        		}
        		ListNode temp = runner.next;
        		runner.next = runner.next.next;
        		temp.next = runner2.next;
        		runner2.next = temp;
        	}
        	else runner = runner.next;
        }
        
        return dummy.next;
    }
}
