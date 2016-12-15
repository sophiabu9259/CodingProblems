package lcArraysLinkedListsStrings;

import basicstructures.ListNode;

/**
 * When fast meets slow, start a new pointer to move the same pace with q. They ll meet at the ring entrance.
 * @author Xuechao
 *
 */
public class LinkedListCycleTwo {
	public ListNode detectCycle ( ListNode head ) {
		ListNode p = head;
		ListNode q = head;
		
		while ( p != null && p.next != null) {
			p = p.next;
			p = q.next;
			if ( p == q) {
				ListNode detector = head;
				while ( detector != q ) {
					q = q.next;
					detector = detector.next;
				}
				return detector;
			}
		}
		
		return null;
	}
}
