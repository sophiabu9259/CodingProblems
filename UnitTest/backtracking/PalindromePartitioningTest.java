package backtracking;

import java.util.List;

import org.junit.Test;

public class PalindromePartitioningTest {
	
	PalindromePartitioning myPP = new PalindromePartitioning();

	@Test
	public void testPartition() {
		String s = "abandonon";
		List<List<String>> ret = myPP.partition(s);
		
		for (List<String> l : ret) {
			for (String e : l) {
				System.out.print(e + ",");
			}
			System.out.println();
		}
	}

}
