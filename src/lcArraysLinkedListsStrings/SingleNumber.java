package lcArraysLinkedListsStrings;

public class SingleNumber {
	/**
	 * Given an array of integers, 
	 * every element appears twice except for one. 
	 * Find that single one.
	 */
	public int singleNumber(int[] input){
		int result = 0; // start with 0, 0^a = a
		for (int i:input){
			result ^= i;
		}
		return result;
	}
}
