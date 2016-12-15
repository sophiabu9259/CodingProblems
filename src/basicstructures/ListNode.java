package basicstructures;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }	
	
	public static boolean equals(ListNode l1,ListNode l2){
		if (l1 == null && l2 == null) return true;
		while(l1 != null && l2 != null){
			if (l1.val != l2.val){
				return false;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 == null && l2 == null){
			return true;
		} 
		return false;
	}
	
	public static ListNode newList(int... x) {
		ListNode dummy = new ListNode(-1);
		ListNode runner = dummy;
		for (int i:x) {
			runner.next = new ListNode(i);
			runner = runner.next;
		}	
		return dummy.next;
	}
	
	public static void printList (ListNode root) {
		while (root != null) {
			System.out.print(root.val + ", ");
			root = root.next;
		}
		System.out.println();
	}
}
