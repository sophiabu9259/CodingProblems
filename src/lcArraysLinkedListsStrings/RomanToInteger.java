package lcArraysLinkedListsStrings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInteger (String input) {
		if (input.length() == 0) {
			return 0;
		}
		int result = 0;
		int temp = 0;
		Map<Character,Integer> hmap = new HashMap<Character, Integer>();
		hmap.put('I',1);
		hmap.put('V', 5);
		hmap.put('X', 10);
		hmap.put('L', 50);
		hmap.put('C', 100);
		hmap.put('D', 500);
		hmap.put('M', 1000);
		
		temp = hmap.get(input.charAt(0));
		for ( int i = 1; i < input.length(); i++) {
			if (hmap.get(input.charAt(i)) <= temp) {
				result += temp;
			} else {
				result -= temp;
			}
			temp = hmap.get(input.charAt(i));
		}
		result += temp;
		return result;
	}
}
