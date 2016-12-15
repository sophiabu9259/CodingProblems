package backtracking;

import java.util.ArrayList;
import java.util.List;
/**
 * same level, send it self again.
 * @author xuechao
 *
 */
public class CombinationSum {
	public List<List<Integer>> comboSum (int[] set, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		backtracking (ret, new ArrayList<Integer>(), set, target, 0);
		return ret;
	}
	
	public void backtracking (List<List<Integer>> ret, List<Integer> temp, int[] set, int target, int start) {
		if ( target == 0) {
			ret.add(new ArrayList<>(temp));
		} else {
			for ( int i = start; i < set.length; i++) {
				if (target >= set[i]) {
					temp.add(set[i]);
					backtracking(ret, temp, set, target-set[i], i);
					temp.remove(temp.size()-1);
				}
				
			}
		}
	}
}
