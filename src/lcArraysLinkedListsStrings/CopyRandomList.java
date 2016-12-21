package lcArraysLinkedListsStrings;

import basicstructures.RandomListNode;

/**
 * Use next pointer to map old to new while keeping the old next in new's next
 * 3 passes: build mapping with next, build random and reconstruct next. 
 * @author Xuechao
 *
 */
public class CopyRandomList {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode res = null;
		RandomListNode cur = head;
		
		if (head == null) return res;

		while (cur != null) {
			RandomListNode shadow = new RandomListNode (cur.label);
			shadow.next = cur.next;
			cur.next = shadow;
			cur = shadow.next;
		}

		cur = head;

		while (cur != null) {
			RandomListNode shadow = cur.next;
			shadow.random = cur.random == null? null : cur.random.next;
			cur = shadow.next;
		}

		cur = head;
		res = cur.next;

		while (cur != null) {
			RandomListNode shadow = cur.next;
			cur.next = shadow.next; 
			shadow.next = cur.next == null? null : cur.next.next;
			cur = cur.next;
		}

		return res;
    }
	
	public static void main (String[] args) {
		RandomListNode a = new RandomListNode (-1);
		
		CopyRandomList o = new CopyRandomList();
		RandomListNode b = o.copyRandomList(a);
		
		while (b != null) {
			System.out.println ("Label: " + b.label);
			b = b.next;
		}
	}
}
