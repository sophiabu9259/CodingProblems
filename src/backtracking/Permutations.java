package backtracking;

import java.util.ArrayList;
import java.util.List;


public class Permutations {
	public List<List<Integer>> permute (int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		backtracking (ret, new ArrayList<Integer>(), nums);
		return ret;
	}
	
	private void backtracking (List<List<Integer>> ret, List<Integer> temp, int[] nums) {
		if ( temp.size() == nums.length) {
			ret.add(new ArrayList<>(temp));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (temp.contains(nums[i])) continue;
				temp.add(nums[i]);
				backtracking(ret, temp, nums);
				temp.remove(temp.size()-1);
			}
		}
	}	
}

