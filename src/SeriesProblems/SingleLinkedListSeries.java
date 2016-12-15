package SeriesProblems;

import basicstructures.ListNode;

public class SingleLinkedListSeries {
	
	public static void main (String[] args) {
		/*
		 * 1. Find Length
		 */
		ListLength.demo();
		
		/*
		 * 2. Reverse a list
		 */
		ReverseLinkedList.demo();
		
		/*
		 * 3.Find reversed Kth
		 */
		FindKthNode.demo();
		
		/*
		 * 4.Find mid Node
		 */
		FindListMid.demo();
		
		/*
		 * 5.Mergesort
		 */
		MergeSort.demo();
	}
	
	/**
	 * check single LinkedList length
	 * @author Xuechao
	 *
	 */
	static class ListLength {
		public static int findLength (ListNode root) {
			if (root == null) {
				return 0;
			}
			
			int len = 0;
			ListNode cur = root;
			while (cur != null) {
				len++;
				cur = cur.next;
			}
			return len;
		}
		
		public static void demo() {
			System.out.println("1. Find Length Test");
			
			ListNode r1 = ListNode.newList(1,2,3);
			System.out.println(ListLength.findLength(r1) == 3? "pass" : "fail");
			System.out.println(ListLength.findLength(null) == 0? "pass": "fail");
			
			System.out.println();
		}
	}
	
	/**
	 * Reverse a List
	 * @author Xuechao
	 *
	 */
	static class ReverseLinkedList {
		static ListNode ReverseList (ListNode root) {
			if (root == null) return root;
			
			ListNode dummy = new ListNode (-1);
			dummy.next = root;
			ListNode cur = root.next;
			
			while (cur != null) {
				root.next = cur.next;
				cur.next = dummy.next;
				dummy.next = cur;
				cur = root.next;
			}
			
			return dummy.next;	
		}
		
		static void demo() {
			
			System.out.println("2. Find Length Test");
			
			ListNode r1 = ListNode.newList(1,2,3,4,5);
			ListNode r2 = ListNode.newList(1);
			ListNode r3 = ListNode.newList(1,2);
			
			r1 = ReverseLinkedList.ReverseList(r1);
			r2 = ReverseLinkedList.ReverseList(r2);
			r3 = ReverseLinkedList.ReverseList(r3);
			
			ListNode.printList(r1);
			ListNode.printList(r2);
			ListNode.printList(r3);
			
			System.out.println();

		}
	}
	/**
	 * Find reversed kth node in a list in one pass.
	 * @author Xuechao
	 *
	 */
	static class FindKthNode {
		/**
		 * k is 1-based index
		 * @param root
		 * @param k
		 * @return
		 */
		static ListNode findK (ListNode root, int k) {
			if (root == null) return root;
			ListNode cur = root;
			while (cur != null && k-- > 0) {
				cur = cur.next;
			}
			/*
			 * K is larger than list length
			 */
			if (k != -1) return null;
			
			ListNode start = root;
			while (cur != null) {
				cur = cur.next;
				start = start.next;
			}
			
			return start;
		}
		
		static void demo() {
			ListNode r1 = ListNode.newList(1,2,3,4,5);
			System.out.println("3. Find Kth Test");
			System.out.println("Find reversed 1 element 5:" + FindKthNode.findK(r1, 1).val);
			System.out.println("Find reversed 2 element 4:" + FindKthNode.findK(r1, 2).val);
			System.out.println("Find reversed 3 element 3:" + FindKthNode.findK(r1, 3).val);
			System.out.println();

		}
	}
	/**
	 * find mid point of a list
	 * @author Xuechao
	 *
	 */
	static class FindListMid {
		static ListNode findMid (ListNode root) {
			if (root == null || root.next == null || root.next.next == null) return root;
			ListNode p = root;
			ListNode q = root;
			
			while (q.next != null && q.next.next != null) {
				p = p.next;
				q = q.next.next;
			}
			
			return p;
			
		}
		
		static void demo() {
			
			System.out.println("4. Find Mid Test");
			
			ListNode r1 = ListNode.newList(1);
			ListNode r2 = ListNode.newList(1,2);
			ListNode r3 = ListNode.newList(1,2,3,4);
			ListNode r4 = ListNode.newList(1,2,3,4,5);
			
			r1 = FindListMid.findMid(r1);
			r2 = FindListMid.findMid(r2);
			r3 = FindListMid.findMid(r3);
			r4 = FindListMid.findMid(r4);
			
			System.out.println("Case [1]" + (r1.val == 1 ? "pass" : "fail"));
			System.out.println("Case [1,2]" + (r2.val == 1 ? "pass" : "fail"));
			System.out.println("Case [1,2,3,4]" + (r3.val == 2 ? "pass" : "fail"));
			System.out.println("Case [1,2,3,4,5]" + (r4.val == 3 ? "pass" : "fail"));
			System.out.println();
			
		}
	}
	
	static class MergeSort {
		static ListNode mergeSort (ListNode l1, ListNode l2) {
			if (l1 == null || l2 == null) {
				return l1 == null? l2 : l1;
			}
			
			ListNode dummy = new ListNode(-1);
			ListNode r1 = l1;
			ListNode r2 = l2;
			ListNode r3 = dummy;
			
			while (r1 != null && r2 != null) {
				if (r1.val < r2.val) {
					r3.next = r1;
					r1 = r1.next;
				} else {
					r3.next = r2;
					r2 = r2.next;
				}
				r3 = r3.next;	
			}
			
			r3.next = r1 == null? r2 : r1;
			return dummy.next;
		}
		
		static void demo() {
			System.out.println("5. Merge Sort");
			ListNode l1 = ListNode.newList(1,3,5,7);
			ListNode l2 = ListNode.newList(2,4,6,8);
			ListNode l3 = mergeSort(l1, l2);
			while (l3 != null) {
				System.out.print(l3.val + ", ");
				l3 = l3.next;
			}
			System.out.println();
		}
	}
	
}
