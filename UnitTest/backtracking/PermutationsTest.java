package backtracking;

import java.util.List;

import org.junit.Test;

public class PermutationsTest {
	
	Permutations myP = new Permutations();
	
	@Test
	public void testPermute() {
		int[] input = {
				1,2,3
		};
		
		List<List<Integer>> ret = myP.permute(input);
		for (List<Integer> l : ret) {
			for ( int e: l) {
				System.out.print(e + ",");
			}
			System.out.println();
		}
	}

}
