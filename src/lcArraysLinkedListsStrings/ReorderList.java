package lcArraysLinkedListsStrings;

import basicstructures.ListNode;

public class ReorderList {
	public ListNode reorder ( ListNode head ) {
		
		if ( head == null || head.next == null ) {
			return head;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		while ( fast != null && fast.next != null && fast.next.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		
		// following slow is the latter half. Reverse it
		// 
		ListNode end = slow.next;
		ListNode reverser = end.next;
		while ( reverser != null ) {
			end.next = reverser.next;
			reverser.next = slow.next;
			slow.next = reverser;
			reverser = end.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		
		ListNode runner2 = head2;
		ListNode runner1 = head;
		while ( runner2 != null ) {
			ListNode temp1 = runner1.next;
			ListNode temp2 = runner2.next;
			
			runner1.next = runner2;
			runner2.next = temp1;
			
			runner1 = temp1;
			runner2 = temp2;
		}
		
		return head;
	}
}
