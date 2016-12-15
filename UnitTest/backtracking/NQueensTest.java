package backtracking;

import java.util.List;

import org.junit.Test;

public class NQueensTest {
	
	NQueens myNQ = new NQueens();

	@Test
	public void testSolveNQueens() {
		List<List<String>> ret = myNQ.solveNQueens(5);
		
		for (List<String> l : ret) {
			for (String s : l) {
				System.out.println(s);
			}
			System.out.println();
		}
	}

}
