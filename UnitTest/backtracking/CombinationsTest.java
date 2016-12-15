package backtracking;

import java.util.List;

import org.junit.Test;

public class CombinationsTest {
	
	Combinations myC = new Combinations();
		
	@Test
	public void testCombine() {
		List<List<Integer>> ret = myC.combine(5, 3);
		
		for (List<Integer> l : ret) {
			for (int e : l) {
				System.out.print(e + ",");
			}		
			System.out.println();
		}
		
	}

}
