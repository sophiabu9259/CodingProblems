package backtracking;

import java.util.ArrayList;
import java.util.List;
/**
 * next pos possible nums from i+1 to n-k+temp.size() inclusively.
 * @author Xuechao
 *
 */
public class Combinations {
	public List<List<Integer>> combine (int n, int k) {
		List<List<Integer>> ret= new ArrayList<>();
		backtracking (ret, new ArrayList<Integer>(), n, k, 0);
		return ret;
	}
	
	public void backtracking (List<List<Integer>> ret, List<Integer> temp, int n, int k, int start) {
		if ( temp.size() == k) { 
			ret.add( new ArrayList<>(temp));
		} else {
			for ( int i = start; i < n - k + temp.size() + 1; i++) {
				temp.add(i+1);
				backtracking(ret, temp, n, k, i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
}
