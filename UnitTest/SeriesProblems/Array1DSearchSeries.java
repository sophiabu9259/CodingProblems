package SeriesProblems;

import java.util.ArrayList;
import java.util.List;

public class Array1DSearchSeries {
	/**
	 * For each starting number S, find its most right element E which satisfies E - S == indexE - indexS.
	 * @author xuechao
	 *
	 */
	static class RangeSummary {
		public List<String> summaryRanges(int[] nums) {
			List<String> ret = new ArrayList<>();
			//edge cases
			if (nums == null || nums.length == 0) {
				return ret;
			}
			//binary search. Finding most right element satisfying
			int index = 0;
			while (index < nums.length) {
				int start = nums[index];
				int lo = index;
				int hi = nums.length -1 ;
				while (lo < hi) {
					int mid = lo + (hi - lo)/2;
					if (nums[mid] > start + mid - index) {
						//get rid of unsatisfying ones
						hi = mid - 1;
					} else {
						//keep possible candidate
						lo = mid;
						//tie breaking. 
						if (lo == hi - 1) {
							if (nums[hi] == nums[lo] + 1) lo++;
							break;
						}
					}
				}
				
				if (lo == index) {
					ret.add("" + start);
				} else {
					ret.add(start + "->" + nums[lo]);
				}
				index = lo + 1;                                                                                                                                                                                                                                                                                       
			}
			
			return ret;
		}
	}
}
