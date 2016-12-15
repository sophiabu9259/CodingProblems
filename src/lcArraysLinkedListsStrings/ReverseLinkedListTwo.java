package lcArraysLinkedListsStrings;
import basicstructures.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * m.n are 1-based position
 */
public class ReverseLinkedListTwo {
	/**
	 * find the node before the reverse head (end after reversion), head2 
	 * find the node of reverse head (the one after haed2), end2
	 * start from the first node to be swapped, cur
	 * hand over cur's next to end2
	 * insert after head2, and take over the previous link after head2 (head insert as a stack)
	 * move to end2's next, or next to be swapped.
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseLinkedList(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode runner = dummy;	
		for (int i = 1; i < m; i++) {
			runner = runner.next;
		}
		
		final ListNode head2 = runner; //start at position m, local immutable
		ListNode end2 = runner.next;
		ListNode cur = end2.next;
		
		for (int i = m; i < n; i++) {
			end2.next = cur.next;
			cur.next = head2.next;
			head2.next = cur;
			cur = end2.next;
		}
		
		return dummy.next;
	}
}
