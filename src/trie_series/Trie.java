package trie_series;

import java.util.*;

class TrieNode {
    // Initialize your data structure here.
	
	TrieNode[] children;
	boolean isEnd;
	
	public TrieNode() {
		this.children = new TrieNode[26];

	}

}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
        	if (cur.children[ch - 'a'] == null) {
        		cur.children[ch - 'a'] = new TrieNode ();
        	}
        	cur = cur.children[ch - 'a'];
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
        	int index = ch - 'a';
        	if (cur.children[index] == null) {
        		return false;
        	}    	
        	cur = cur.children[index];
        }
        
        return cur.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
        	int index = ch - 'a';
        	if (cur.children[index] == null) {
        		return false;
        	}    	
        	cur = cur.children[index];
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
