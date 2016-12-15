package lcArraysLinkedListsStrings;

import java.util.HashSet;
import java.util.Set;
/**
 * use two pointer hi, lo. 
 * @author xuechao
 *
 */
public class ReverseVowelsofaString_345_E {
	public String reverseVowels(String s) {
        if (s == null) return s;
        
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('o');
        vowels.add('e');
        vowels.add('i');
        vowels.add('u');
        vowels.add('A');
        vowels.add('O');
        vowels.add('E');
        vowels.add('I');
        vowels.add('U');
        
        char[] arr = s.toCharArray();
        int lo = 0;
        int hi = arr.length-1;
        
        while (lo < hi) {
        	while (lo < hi) {
        		if (vowels.contains(arr[lo])) {
        			break;
        		} else {
        			lo++;
        		}
        	}
        	
        	while (lo < hi) {
        		if (vowels.contains(arr[hi])) {
        			break;
        		} else {
        			hi--;
        		}
        	}
        	
        	if (hi != lo) {
        		char c = arr[lo];
        		arr[lo] = arr[hi];
        		arr[hi] = c;
        	}
        	
        	lo++;
        	hi--;
        }
        
        return new String(arr);
    }
}
