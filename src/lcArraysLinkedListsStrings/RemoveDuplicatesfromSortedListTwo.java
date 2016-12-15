package lcArraysLinkedListsStrings;

import basicstructures.ListNode;

/**
 * 1. Scan to the next distinct value
 * 2. Use a temp to determine. Clear temp meeting dups, save temp meeting distincts, and cache current val when temp is cleared. Careful for
 * the first one. Need a dummy to maybe skip first node. Care last one: save the cached value if not null, cuz it has to been non-dup. It is
 * not cleared, so it is diffrent from last one. Care clearing. Maybe not only two appearance. So added dupVal to record more than twice appearing 
 * values.
 * @author Xuechao
 *
 */
public class RemoveDuplicatesfromSortedListTwo {
	public ListNode removeDuplicatesTwo(ListNode head) {
		
		if (head == null)  {
			return null;
		}
		
		ListNode dummy = new ListNode(-1);
		
		ListNode saver = dummy;
		ListNode runner = head;
		ListNode temp = null;
		int dupVal = head.val+1;
		while (runner != null) {
				
			
			if (temp == null) { // last duplicates deleted, start to check duplicates again
				temp = runner;
				runner = runner.next;
			} else if (runner.val == temp.val) { //duplicates found
				temp = null;
				dupVal = runner.val;
				runner = runner.next;
			} else if (temp.val != dupVal){ //last temp not null, runner distinct from temp. Non-duplicate
				saver.next = temp;
				temp = runner;
				runner = runner.next;
				saver = saver.next;
				dupVal = saver.val;
			} else {
				temp = runner;
				runner = runner.next;
			}
		}
		
		if (temp != null && temp.val != dupVal) {
			saver.next = temp;
			saver = saver.next;
		} else {
			saver.next = null;
		}
		return dummy.next;
		
		
	}
}
