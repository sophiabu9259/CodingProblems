package lcArraysLinkedListsStrings;
/**
 * typical binary search. But keep searching for both side even mid meet, until -1,-1 or not found. 
 * @author xuechao
 *
 */
public class SearchForARange {
	public int[] searchRange (int[] input, int target) {
		if (input == null || input.length == 0) {
			int[] result = {-1,-1};
			return result;
		}
		return helper (input,target,0, input.length-1);
	}
	
	private int[] helper (int[] input, int target, int start, int end) {
		int[] result = {
				-1, -1
		};
		
		if (start > end) {
			return result;
		}
		
		int mid = (start+end)/2;
		if (input[mid] > target) {
			return helper (input, target, start, mid-1);
		} else if (input[mid] < target) {
			return helper (input, target, mid+1, end);
		} else {
			int[] leftRange = helper (input, target, start, mid-1);
			int[] rightRange = helper (input,target, mid+1, end);
			result[0] = leftRange[0] == -1? mid : leftRange[0];
			result[1] = rightRange[0] == -1? mid : rightRange[1];
		}
		
		return result;
	}
}
