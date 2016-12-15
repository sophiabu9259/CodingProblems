package snap.inc;

import java.util.*;

public class SimpleWord {
	/*
	 * given an array of words. output array of simple words. 
	 * compound word are made of multiple simple words. 
	 * "chat ever snapchat snap salesperson per person sales 
	 * son whatsoever what so" 
	 * ∆‰÷–simple word «chat, ever, snap, per, sales, son, what, so 
	 */
/*	
	String[] dictarr = {
//			"chat", "ever", "snapchat", "snap", "salesperson", "per", "person","sales", "son" , "whatsoever", "what", "so"
			"what", "the", "fuck", "thefuck", "fu", "ck", "what", "a", "w", "ht"
	};
	
	String[] simpleSet = {
//			"chat", "ever", "snap", "per", "sales", "son", "what", "so"
			"what", "the", "fu", "ck", "a", "w", "ht"
	};
	
*/
	public boolean isCompound (String input, Set<String> dict) {
		boolean[] check = new boolean[input.length() + 1];
		check[0] = true;
		
		for (int i = 0; i < input.length() + 1; ++i) {
			if (!check[i]) continue;
			
			for (String word : dict) {
				if (i + word.length() < input.length() + 1) {
					if (input.substring (i, i + word.length()).equals(word)) {
						check[i + word.length()] = true;
					}
				}
			}
		}
		
		return check[input.length()];
	}
	
	public String[] findSimple (String[] inputs) {
		List<String> list = new ArrayList<String> (Arrays.asList(inputs));
		Set<String> set = new HashSet<>();
		set.addAll(list);
		
		Set<String> copy = new HashSet<>(set);
		List<String> ret = new ArrayList<>();
		
		for (String input : set) {
			copy.remove(input);
			if (!isCompound (input, copy) || input.length() == 0) {
				ret.add(input);
			}
			copy.add(input);
		}
		
		String[] retArr = new String[ret.size()];
		
		for (int i = 0; i < retArr.length; ++i) {
			retArr[i] = ret.get(i);
		}
		
		return retArr;
	}
	
	public static void main (String[] args) {
		String[] dictarr = {
				"chat", "ever", "snapchat", "snap", "salesperson", "per", "person","sales", "son" , "whatsoever", "what", "so", ""
//				"what", "the", "fuck", "thefuck", "fu", "ck", "what", "a", "w", "ht"
		};
		
		String[] simpleSet = {
				"chat", "ever", "snap", "per", "sales", "son", "what", "so"
//				"what", "the", "fu", "ck", "a", "w", "ht"
		};
		
		SimpleWord sw = new SimpleWord();
		String[] ret = sw.findSimple(dictarr);
		
		for (String s : ret) {
			System.out.print(", "+ s );
		}
	}
}
