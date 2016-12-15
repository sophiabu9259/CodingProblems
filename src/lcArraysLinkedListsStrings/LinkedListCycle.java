package lcArraysLinkedListsStrings;

import basicstructures.ListNode;
/**
 * Classic two pointers.
 * @author Xuechao
 *
 */
public class LinkedListCycle {
	public boolean hasCycle ( ListNode head ) {
		ListNode p;
		ListNode q;
		
		p = head;
		q = head;
		
		while ( p != null ) {
			q = q.next;
			if ( p.next != null ) {
				p = p.next.next;
			} else {
				return false;
			}
			if ( p == q ) {
				return true;
			}
		}
		
		return false;
	}
}
