package lcArraysLinkedListsStrings;

public class SearchInsertPosition {
	public int searchInsertPosition (int[] input, int target) {
		if ( input == null || input.length == 0) {
			return 0;
		}
		
		return helper (input,target,0,input.length-1);
	}
	
	private int helper (int[] input, int target, int start, int end) {
		if ( start == end ) {
			if (target <= input[start]) return start;
			else if (target > input[start] ) return start+1;
		}
		
		int mid = (start+end)/2;
		if ( input[mid] > target) {
			return helper(input,target,start,mid);
		} else if (input[mid] < target) {
			return helper(input,target,mid+1,end);
		} else return mid;
	}
}
