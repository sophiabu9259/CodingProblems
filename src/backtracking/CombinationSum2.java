package backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * use a index list. If index list contains its previous same-value entry, they are not on same level, otherwise they are same-leveled, skip it.
 * @author xuechao
 *
 */
public class CombinationSum2 {
	public List<List<Integer>> comboSum2(int[] set, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(set);
		backtracking(ret, new ArrayList<Integer>(), new ArrayList<Integer>(), set, target, 0);
		return ret;
	}
	
	private void backtracking (List<List<Integer>> ret, List<Integer> temp, List<Integer> indexList,int[] set, int target, int start) {
		if (target == 0) {
			ret.add(new ArrayList<>(temp));
		} else if (target < 0) {
			return;
		} else {
			for ( int i = start; i < set.length; i++) {
				if (i != 0 && set[i] == set[i-1] && !indexList.contains(i-1)) continue;
				indexList.add(i);
				temp.add(set[i]);
				backtracking(ret, temp, indexList, set, target-set[i], i+1);
				temp.remove(temp.size()-1);
				indexList.remove(indexList.size()-1);
			}
		}
	}
}
