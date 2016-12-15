package lcArraysLinkedListsStrings;
/**
 * corner case {1,1}. input should be {1,2,3,4,5} if any place like {1,-1,3,4,5} happens, return that wrong place index +1; 
 * @author Xuechao
 *
 */
public class FindFirstMissingPositive {
	public int findFirstMissingPositive (int[] nums) {
		int i = 0;
		while ( i < nums.length) {
			if ( nums[i] == i+1 || nums[i] < 1 || nums[i] > nums.length) {
				i++;
				continue;
			} else {
				int temp = nums[i];
				nums[i] = nums[temp-1];
				nums[temp-1] = temp;
				if (nums[i] == nums[temp-1]) {
					i++;
				}
			}
		}
		int j = 0;
		for (; j < nums.length; j++) {
			if (nums[j] != j+1) {
				break;
			}
		}
		
		return j+1;
	}
}
