package backtracking;


import java.util.Date;
import java.util.List;
import org.junit.Test;

public class Permutations2Test {
	Permutations2 myP2 = new Permutations2();
	
	@Test 
	public void testPermutes() {
		int[] nums = {
				1,1,2
		};
		Date date = new Date();
		
		System.out.println("Start: " + date.toString());
		
		List<List<Integer>> ret = myP2.permutes(nums);
		
		for (List<Integer> l : ret) {
			for (int e : l) {
				System.out.print(e+", ");
			}
			System.out.println();
		}
		
		
		System.out.println("End: " + date.toString());

		
	}

}
