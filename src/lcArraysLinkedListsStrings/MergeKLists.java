package lcArraysLinkedListsStrings;

import java.util.Comparator;
import java.util.PriorityQueue;

import basicstructures.ListNode;

public class MergeKLists {
	public ListNode mergeKLists (ListNode[] lists) {
		MergeTwoLists myMTL = new MergeTwoLists();
		if (lists.length < 2) {
			return lists.length == 0? null:lists[1];
		}
		ListNode merged = lists[0];
		
		for (int i = 1; i < lists.length; i++) {
			merged = myMTL.mergeTwoLists(merged, lists[i]);
		}
		return merged;
	}
	
	public ListNode mergeKListsHeap (ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>( new Comparator<ListNode>(){
			public int compare (ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});
		
		for (ListNode e : lists) {
			if (e != null) {
				heap.offer(e);
			}
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode runner = dummy;
		while (!heap.isEmpty()) {
			runner.next = heap.poll();
			runner = runner.next;
			if (runner.next != null) {
				heap.offer(runner.next);
			}
		}
		return dummy.next;
	}
}
