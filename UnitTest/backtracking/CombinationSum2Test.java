package backtracking;

import java.util.List;

import org.junit.Test;

public class CombinationSum2Test {
	CombinationSum2 myCS2 = new CombinationSum2();
	@Test
	public void testComboSum2() {
		int[] test = {
				10, 1, 2, 7, 6, 1, 5
		};
		
		List<List<Integer>> ret = myCS2.comboSum2(test, 8);
		for (List<Integer> l : ret) {
			for (int e : l) {
				System.out.print(e+",");
			}
			System.out.println();
		}
	}

}
