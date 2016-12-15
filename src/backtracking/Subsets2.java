package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * use temp to store current path. skip same-level duplicates.
 * @author xuechao
 *
 */
public class Subsets2 {
	public List<List<Integer>> subsetsWithDup (int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);
		backtracking (ret, new ArrayList<Integer>(), nums, 0);
		return ret;
	}
	
	private void backtracking (List<List<Integer>> ret, List<Integer> temp, int[] nums, int start) {
		ret.add(new ArrayList<>(temp));
		for ( int i = start; i < nums.length; i++) {
			if ( i == start || nums[i] != nums[i-1] ) { // when i == start, even nums[i] == nums[i-1], nums[i-1] is on a higher level, they are different. but after that, skip all same-level duplicates. 
				temp.add(nums[i]);
				backtracking (ret, temp, nums, i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
}
