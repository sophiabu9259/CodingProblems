package backtracking;

import org.junit.Test;

public class SudokuSolverTest {
	SudokuSolver mySS = new SudokuSolver();
	@Test (timeout = 10000)
	public void testSolveSudoku() {
		char[][] board = {
				"53..7....".toCharArray(),
				"6..195...".toCharArray(),
				".98....6.".toCharArray(),
				"8...6...3".toCharArray(),
				"4..8.3..1".toCharArray(),
				"7...2...6".toCharArray(),
				".6....28.".toCharArray(),
				"...419..5".toCharArray(),
				"....8..79".toCharArray()
		};
		
		mySS.solveSudoku(board);
		for (char[] a : board) {
			for (char c : a) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	@Test (timeout = 10000)
	public void testSolveSudoku2() {
		char[][] board = {
				"53..7....".toCharArray(),
				"6..195...".toCharArray(),
				".98....6.".toCharArray(),
				"8...6...3".toCharArray(),
				"4..8.3..1".toCharArray(),
				"7...2...6".toCharArray(),
				".6....28.".toCharArray(),
				"...419..5".toCharArray(),
				"....8..79".toCharArray()
		};
		
		mySS.solve(board);
		for (char[] a : board) {
			for (char c : a) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}

}
