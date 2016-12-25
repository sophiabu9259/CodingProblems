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
	
	Map<Integer, Node> lookup;
	Node head;
	Node tail;

	int size;
	int capacity;



	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		Node (int k, int v) {
			this.value = v;
			this.key = k;
		}
	}

	void insertHead (Node e) {
		e.next = head.next;
		head.next.prev = e;
		head.next = e;
		e.prev = head;
	}

	void removeFromList (Node e) {
		e.prev.next = e.next;
		e.next.prev = e.prev;
	}

	void removeFromMap (Node e) {
		this.lookup.remove (e.key);
		this.size--;
	}

	void removeAll (Node e) {
		removeFromList (e);
		removeFromMap (e);
	}



    public LRUCache(int capacity) {
    	if (capacity == 0) {
    		System.out.println ("Wrong Capacity");
    		capacity = 10;
    	}

    	this.lookup = new HashMap<>();

        this.head = new Node (-1, -1);
        this.tail = new Node (-1, -1);
        head.next = tail;
        tail.prev = head;

        this.size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!this.lookup.containsKey(key)) return -1;
        Node e = this.lookup.get(key);
        removeFromList(e);
        insertHead (e);   
        return e.value;
    }
    
    public void set(int key, int value) {
        if (this.lookup.containsKey (key)) {
        	Node e = this.lookup.get(key);
        	e.value = value;
        	removeFromList (e);
        	insertHead (e);
        } else {
            if (this.lookup.size() == this.capacity) {
        		removeAll (this.tail.prev);
        	} 
        	
        	Node e = new Node (key, value);
        	this.lookup.put (key, e);
        	insertHead (e);
        }
    }
    
}
