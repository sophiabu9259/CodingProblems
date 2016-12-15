package codingskillandtrivialimplementations;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		//edge cases.
		
		List<String> ret = new ArrayList<>();
		
		if (nums == null || nums.length == 0 || upper < lower) {
			return ret;
		}
		
		// empty cases
		if (upper < nums[0] || lower > nums[nums.length-1]) {
			return ret;
		}

		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] < lower) {
				continue;
			}
			if (nums[i+1] <= upper && nums[i + 1] - nums[i] > 1) {
				ret.add(nums[i+1] - nums[i] == 2? "" + (nums[i] + 1): (nums[i] + 1) + "->" + (nums[i+1] - 1));
			}
		}

		if (nums[nums.length-1] < upper) {
			ret.add(upper - nums[nums.length-1] == 1? "" + upper : (nums[nums.length+1] + 1) + "->" + upper);
		}
		return ret;
	}
}
