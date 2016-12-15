package lcArraysLinkedListsStrings;

import basicstructures.ListNode;

public class RotateList {
	public ListNode rotate(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		
		ListNode runner = head;
		ListNode end = null;
		int length = 0;
		
		while (runner != null) {
			length++;
			if (runner.next == null) {
				end = runner;
			}
			runner = runner.next;
		}
		
		k %= length;
		if ( k == 0) return head;
		
		runner = head;
		for (int i = 0; i < length - k - 1; i++) {
			runner = runner.next;
		}
		
		ListNode newHead;
		newHead = runner.next;
		end.next = head;
		runner.next = null;
		
		return newHead;		
	}
}
