package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Permutations2 {
	public List<List<Integer>> permutes (int[] nums) {
		List<List<Integer>>	ret = new ArrayList<>();
		Arrays.sort(nums);
		backtracking(ret, new ArrayList<Integer>(), new ArrayList<Integer>(), nums);
		return ret;
	}
	
	private void backtracking (List<List<Integer>> ret, List<Integer> temp, List<Integer> indexList, int[] nums) {
		if (temp.size() == nums.length) {
			ret.add(new ArrayList<>(temp));
		} else {

			for (int i = 0; i < nums.length; i++) {
				if (i != 0 && nums[i] == nums[i-1] && !indexList.contains(i-1)) continue;
				if (indexList.contains(i)) continue;
				indexList.add(i);
				temp.add(nums[i]);
				backtracking(ret, temp, indexList, nums);
				indexList.remove(indexList.size()-1);
				temp.remove(temp.size()-1);
			}
		}
	}
	
}