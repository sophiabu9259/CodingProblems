package simpletests;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;
/**
 * Test : whats the order of PQ?
 * Result : default smaller at the front.
 * @author xuechao
 *
 */
public class PriorityQueueTest {

	@Test
	public void test() {
		System.out.println("Test1");
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare (Integer i1, Integer i2) {
				return i1-i2;
			}
		});
		
		pq.add(5);
		pq.add(6);
		pq.add(1);
		
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
		System.out.println("");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
		/**
		 * Test whats the order of equally inserted elements?
		 */
		class Node {
			int value;
			String label;
			int priority;
			Node (int i, String s, int p) {
				this.value = i;
				this.priority = p;
				this.label = s;
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare (Node n1, Node n2) {
				return n1.value == n2.value? n1.priority - n2.priority : n1.value - n2.value;
			}
		});
		int count = 0;
		pq.add(new Node(1,"1Old", ++count));
		pq.add(new Node(2,"2Old", ++count));
		pq.add(new Node(1,"1New", ++count));
		pq.add(new Node(2,"2New", ++count));
		
		while (!pq.isEmpty()) {
			System.out.print(pq.poll().label + " ");
		}
		System.out.println("");
	}
	
	@Test
	public void test23() {
		/**
		 * Test whether the queue reshuffle.
		 * Result : No
		 */
		System.out.println("Test3");
		class Node {
			int value;
			String label;
			Node (int i, String s, int p) {
				this.value = i;
				this.label = s;
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare (Node n1, Node n2) {
				return n1.value - n2.value;
			}
		});
		int count = 0;
		Node a = new Node(2,"2Old",++count);
		pq.add(new Node(1,"1Old", ++count));
		pq.add(a);
		a.value = 0;
		
		
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			System.out.print(" " + top.value + top.label);
		}
		System.out.println("");
	}

}
