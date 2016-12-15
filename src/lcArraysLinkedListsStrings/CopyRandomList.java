package lcArraysLinkedListsStrings;

import basicstructures.RandomListNode;

/**
 * make a map connection from each node to its shadow node. Notice the end.
 * @author Xuechao
 *
 */
public class CopyRandomList {
	public RandomListNode deepCopyRandom (RandomListNode head) {
		RandomListNode p = head;
		if ( p == null) {
			return p;
		}
		
		while (p!=null) {
			RandomListNode shadow = new RandomListNode(p.label);
			shadow.next = p.next;
			p.next = shadow;
			p = shadow.next;
		}
		
		p = head;
		while (p!=null) {
			if (p.random != null) {
				p.next.random = p.random.next;
			}	
			p = p.next.next;
		}
		
		p = head.next.next;
		RandomListNode q = head.next;
		
		while (p!=null) {
			q.next = p.next;
			p = p.next.next;
			q = q.next;
		}
		
		return  head.next;
	}
}
