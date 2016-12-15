package lcArraysLinkedListsStrings;

import basicstructures.ListNode;

/**
 * use saver to save distinct vals, use runner to skip duplicate ones. 
 * Dummy optional because no need to insert before the head.
 * @author Xuechao
 *
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates (ListNode head) {
		
		if (head == null) return null;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode saver = dummy.next;
		ListNode runner = dummy.next.next;
		
		while (runner != null) {
			if (runner.val != saver.val) {
				saver.next = runner ;
				saver = saver.next;
				runner = runner.next;
			} else {
				runner = runner.next;
			}
		}
		
		saver.next = null;
		return dummy.next;
	}
}
