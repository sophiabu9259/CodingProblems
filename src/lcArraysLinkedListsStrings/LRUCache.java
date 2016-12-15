package lcArraysLinkedListsStrings;

import java.util.HashMap;
import java.util.Map;

class Node {
	int key; // used for removal
	int value;
	Node next;
	Node prev;
	
	Node (int key, int value) {
		this.key = key;
		this.value = value;
		next = null;
		prev = null;
	}
}

/**
 * Implement attach and detach functions.
 * @author Xuechao
 *
 */

public class LRUCache {
	
	Node head = null;
	Node tail = null;
	int capacity;
	 //int size; use map.size()
	Map<Integer, Node> mymap = new HashMap<>();
	
	public LRUCache (int capacity) {
		this.capacity = capacity;
		head = new Node(-1,-1);
		tail = new Node(-1,-1);
		head.next = tail;
		tail.prev = head;
		
	}
	
	/**
	 * key value pair still inside hashmap.
	 * @param touched
	 */
	public void detach ( Node touched ) {
		touched.prev.next = touched.next;
		touched.next.prev = touched.prev;
	}
	
	public void attach ( Node touched ) {
		head.next.prev = touched;
		touched.next = head.next;
		
		touched.prev = head;
		head.next = touched;
	}
	
	public int get (int key) {
		
		int result = -1;
		Node valueContainer = mymap.get(key);
		
		if (valueContainer != null) {
			result = valueContainer.value;
			detach(valueContainer);
			attach(valueContainer);
		}
		
		return result;
	}
	
	public void set (int key, int value) {
		
		if (mymap.containsKey(key)) {
			Node toucher = mymap.get(key);
			toucher.value = value;
			detach (toucher);
			attach (toucher);
		} else {
			if (mymap.size() >= capacity) {
				mymap.remove(tail.prev.key);
				detach (tail.prev);	
			}	
			Node toucher = new Node (key,value);
			mymap.put(key,toucher);
			attach (toucher);
		}
				
	}
	
}
