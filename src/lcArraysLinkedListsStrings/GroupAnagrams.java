package lcArraysLinkedListsStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Use int[] to get all appearances of each string. Converse to string as a hashcode 
 *  * @author Xuechao
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams (String[] inputs) {
		List<List<String>> result= new ArrayList<>();
		Map<Integer,Integer> indexMap = new HashMap<>();
		
		for (String e : inputs) {
			int hashcode = hashHelper(e);
			if (indexMap.containsKey(hashcode)) {
				result.get(indexMap.get(hashcode)).add(e);
			} else {
				List<String> temp = new ArrayList<>();
				temp.add(e);
				result.add(temp);
				indexMap.put(hashcode, result.size()-1);
			}
		}
		return result;
	}
	
	public int hashHelper (String input) {
		int[] chars = new int[26];
		char[] inputArrays = input.toCharArray();
		for (char c : inputArrays) {
			chars[c-'a'] ++;
		}
		return Arrays.hashCode(chars);
	}
}
