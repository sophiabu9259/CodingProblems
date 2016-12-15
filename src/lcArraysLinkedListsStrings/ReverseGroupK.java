package lcArraysLinkedListsStrings;

import basicstructures.ListNode;
/**
 * send i % k == 0 nodes to a reverse function
 * @author Xuechao
 *
 */
public class ReverseGroupK {
	public ListNode reverseK (ListNode head, int k) {
		
		if (head==null || k == 0 || k == 1) {
			return head;
		}
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode start = dummy;
		ListNode runner = head;
		int count = 0;
		
		while (runner != null) {
			count ++;
			if (count%k == 0) {
				start = reverseTwoEnds(start,runner);
				runner = start.next;
			} else {
				runner = runner.next;
			}
		}
		
		return dummy.next;
		
	} 
	
	public ListNode reverseTwoEnds(ListNode start, ListNode runner) {
		ListNode p = start.next;
		ListNode end = runner.next;
		
		while (p.next != end)  {
			ListNode q = p.next;
			p.next = q.next;
			q.next = start.next;
			start.next = q;		
		}
		
		return p;
	}
}
