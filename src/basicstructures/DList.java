package basicstructures;

public class DList {
	
	class DNode {
		int val;
		DNode next;
		DNode prev;
		
		DNode (int val) {
			this.val = val;
		}
	}
	
	final DNode head;
	final DNode tail;
	
	DList () {
		//TODO
		head = new DNode (-1);
		tail = new DNode (-1);
		head.next = tail;
		tail.prev = head;
	}
	
	DNode find (int target) {
		DNode cur = head.next;
		while (cur != null) {
			if (cur.val == target) {
				return cur;
			}
			cur = cur.next;
		}
		
		return head;
	}
	
	void removeFront () {
		if (head.next != tail) {
			head.next.next.prev = head;
			head.next = head.next.next;
		}
	}
	
	void removeBack () {
		if (tail.prev != head) {
			tail.prev.prev.next = tail;
			tail.prev = tail.prev.prev;
		}
	}
	
	void addFront (int val) {

			DNode temp = new DNode(val);
			temp.next = head.next;
			head.next.prev = temp;
			head.next = temp;
			temp.prev = head;

		
	}
	
	void addEnd (int val) {

			DNode temp = new DNode (val);
			temp.prev = tail.prev;
			tail.prev.next = temp;
			temp.next = tail;
			tail.prev = temp;

	}
		
	/*
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *
	 * Error log:
	 * not moving forward in while loop
	 * did not establish head and tail
	 */
	
	public String toString() {
		DNode cur = head.next;
		StringBuilder sb = new StringBuilder();
		while (cur != tail) {
			sb.append(cur.val);
			cur = cur.next;
		}
		return sb.toString();
	}
	
	public static void main (String[] args) {
		int[] test = {1, 2, 3, 4, 5, 6};
		DList dl = new DList();
		
		for (int e : test) {
			dl.addEnd(e);
		}
		
		System.out.println("Test addEnd:" + (dl.toString().equals("123456") ? true : ", output " + dl.toString()));
		
		dl.removeBack();
		
		System.out.println("Test removeBack:" + (dl.toString().equals("12345")  ? true : ", output " + dl.toString()));
		
		dl.removeFront();
		
		System.out.println("Test removeFront: " + ( dl.toString().equals("2345") ? true : ", output " + dl.toString()));
		
		DNode t = dl.find(2);
		
		System.out.println("Test find: " + (t == dl.head.next));
		
		dl.removeFront();
		
		System.out.println("Test removeFront: " + ( dl.toString().equals("345") ? true : ", output " + dl.toString()));

		dl.removeBack();
		
		System.out.println("Test removeFront: " + ( dl.toString().equals("34") ? true : ", output " + dl.toString()));
		
		dl.removeBack();dl.removeBack();dl.removeBack();dl.removeBack();
		dl.removeFront();dl.removeFront();dl.removeFront();dl.removeFront();
		
		dl.addFront(5);
		
		System.out.println("Test removeFront: " + ( dl.toString().equals("5") ? true : ", output " + dl.toString()));
		
		System.out.println("Finished");
		
		
	}
	
}


