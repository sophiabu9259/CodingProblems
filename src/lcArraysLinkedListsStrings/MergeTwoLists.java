package lcArraysLinkedListsStrings;

import basicstructures.ListNode;
/**
 * use dummy head and link the smaller one  of two lists.
 * @author Xuechao
 *
 */
public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null? l2 : l1;
		}
        ListNode dummy = new ListNode(-1);
        ListNode r1 = l1;
        ListNode r2 = l2;
        ListNode cur = dummy;
        
        while (r1 != null && r2!=null) {
        	if ( r1.val > r2.val) {
        		cur.next = r2;
        		cur = r2;
        		r2 = r2.next;
        	} else {
        		cur.next = r1;
        		cur = r1;
        		r1 = r1.next;
        	}
        }
        
        if ( r1 == null) {
        	cur.next = r2;
        } else {
        	cur.next = r1;
        }
        return dummy.next;
    }
}
