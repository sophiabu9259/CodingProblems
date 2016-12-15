package backtracking;

import java.util.ArrayList;
import java.util.List;
/**
 * O(2^n) 
 * @author xuechao
 *
 */
public class Subsets {
	public List<List<Integer>> subsets (int[] all) {
		List<List<Integer>> ret = new ArrayList<>();
		ret.add(new ArrayList<Integer>());
		
		for (int e : all) {
			List<Integer> presence  = new ArrayList<Integer>();
			presence.add(e);
			
			List<List<Integer>> newRet = new ArrayList<>();
			
			for ( List<Integer> list : ret) {
				List<Integer> pList = new ArrayList<>();
				pList.addAll(list);
				pList.addAll(presence);
				
				List<Integer> qList = new ArrayList<>();
				qList.addAll(list);
				
				newRet.add(pList);
				newRet.add(qList);
				ret = newRet;			
			}			
		}
		return ret;
	}
}
