package snap.inc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordAbbreviation {
	
	public static void main (String[] args) {
		String[] inputs = {
				"internet", "interval", "internal", "like", "god"
		};
		
		String[] flipped = new String[inputs.length];
		for (int i = 0; i < inputs.length; ++i) {
			flipped[i] = preprocess (inputs[i]);
		}
		
		String[] result = test (flipped);
		
		String[] expected = {
				"i8t", "interval", "internal", "l4e", "god"
		};
		
		System.out.println(Arrays.toString(result));
		

	}
	
	public static String[] test(String[] inputs) {
		Map<Integer, Trie> map = new HashMap<>();;
		
		String[] ret = new String[inputs.length];
		
		//insert strings into their len-Trie
		for (String input : inputs) {
			int len = input.length();
			if (!map.containsKey(len)) {
				map.put(len, new Trie());
			}
			
			map.get(len).insert(input);
		}
		
		for (int i = 0; i < inputs.length; ++i) {
			try {
				ret[i] = postprocessing (map.get(inputs[i].length()).findAndCompress(inputs[i]));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	private static String preprocess (String input) {
		StringBuilder sb = new StringBuilder(input);
		sb.insert(0, input.charAt(input.length() - 1));
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	private static String postprocessing (String input) {
		StringBuilder sb = new StringBuilder (input);
		sb.append(sb.charAt(0));
		sb.deleteCharAt(0);
		return sb.toString();
	}
}

class Trie {
	TrieNode root;
	
	Trie () {
		this.root = new TrieNode();
	}
	
	void insert (String input) {
		TrieNode cur = root;
		
		for (char ch : input.toCharArray()) {
			int index = ch - 'a';
			if (cur.children[index] == null) {
				cur.children[index] = new TrieNode ();
				cur.numOfChildren ++;
			} else {
				cur.numOfChildren ++;
			}
			cur = cur.children[index];
		}
		
	}
	
	String findAndCompress (String input) throws Exception {
		StringBuilder ret = new StringBuilder();
		TrieNode cur = root;
		boolean record = true;
		
		// assert input is in the Trie
		for (char ch : input.toCharArray()) {
			int index = ch - 'a';
			
			if (cur == root) {
				cur = cur.children[index];
				ret.append(ch);
				continue;
			}
			
			cur = cur.children[index];
			if (cur.numOfChildren > 1) {
				ret.append(ch);
				continue;
			}
			
			if (record) {
				ret.append(ch);
				System.out.println("stopped at " + ch);
				record = false;
			}
		}
		
		ret.append(input.length());
		
		
		return ret.length() < input.length() ? ret.toString() : input;
	}
}

class TrieNode {
	int numOfChildren;
	TrieNode[] children;
	
	TrieNode () {
		children = new TrieNode[26];
	}
}