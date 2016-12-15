package lcArraysLinkedListsStrings;

import basicstructures.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null? l2:l1;
		}
		
		ListNode r1 = l1;
		ListNode r2 = l2;
		ListNode lastValid = null;
		int validListHead = 0;
		
		int carrier = 0;
		while (r1 != null || r2 != null) {
			if (r1 == null) {
				r2.val = r2.val + carrier;
				if (r2.val >= 10) {
					r2.val -= 10;
					carrier = 1;
				} else {
					carrier = 0;
				}
			} else if (r2 == null) {
				r1.val += carrier;
				if (r1.val >= 10) {
					r1.val -= 10;
					carrier = 1;
				} else {
					carrier = 0;
				}
			} else {
				r1.val = r2.val = r1.val+r2.val+carrier;
				if (r1.val >= 10) {
					r1.val -= 10;
					r2.val -= 10;
					carrier = 1;
				} else {
					carrier = 0;
				}
			}
			
			if (r1 == null) {
				lastValid = r2;
				validListHead = 2;
				r2 = r2.next;
				continue;
			} else if (r2 == null) {
				lastValid = r1;
				validListHead = 1;
				r1 = r1.next;
				continue;
			} else {
				lastValid = r1;
				validListHead = 1;
				r1 = r1.next;
				r2 = r2.next;
			}
		}
		
		if (carrier == 1) {
			lastValid.next = new ListNode(1);
		}
		
		return validListHead == 1? l1:l2;
    }
}
