package lcArraysLinkedListsStrings;

import basicstructures.ListNode;

public class SwapNodeInPairs {
	public ListNode swapPairs(ListNode head) {
		
		if (head == null) return null;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode runner = dummy;
		while (runner.next != null && runner.next.next != null) {
			
			ListNode p = runner.next;
			ListNode q = p.next;
			
			p.next = q.next;
			q.next = p;
			runner.next = q;
			
			runner = p;	
		}
		return dummy.next;
	}
}
