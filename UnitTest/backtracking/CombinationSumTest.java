package backtracking;

import java.util.List;

import org.junit.Test;

public class CombinationSumTest {
	CombinationSum myCS = new CombinationSum();
	@Test
	public void testComboSum() {
		int[] set = {
				1,2,3,6,7
		};
		
		List<List<Integer>> ret = myCS.comboSum(set, 7);
		for ( List<Integer> l : ret) {
			for ( int e : l) {
				System.out.print(e+",");
			}
			System.out.println();
		}
	}

}
