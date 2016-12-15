package snap.inc;
import java.util.*;

public class ValidSudoko {
	public boolean validSudoko (char[][] board) {
		/*
		 * check row
		 * check col
		 * check subblock
		 */
		
		List<Integer> checklist = null;
		
		
		for (int i =0; i < board.length; ++i) {
			checklist = new ArrayList<>();
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					checklist.add(num);
				}
			}
			if (!check(checklist)) return false;
		}
		
		
		
		for (int j = 0; j < board[0].length; ++j) {
			checklist = new ArrayList<>();
			for (int i = 0; i < board.length; ++i) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					checklist.add(num);
				}
			}
			if (!check(checklist)) return false;
		}
		
		
		
		for (int i = 0; i < board.length; i += 3) {
			for (int j = 0; j < board[0].length; j += 3) {
				checklist = new ArrayList<>();
				for (int m = i; m < i + 3; ++m) {
					for (int n  = j; n < j + 3; ++n) {
						if (board[m][n] != '.') {
							int num = board[m][n] - '0';
							checklist.add(num);
						}
					}
				}
				
				if (!check(checklist)) return false;
			}
		}
		
		return true;
	}
	
	private boolean check (List<Integer> checklist) {
		boolean[] found = new boolean[9];
		
		for (int e : checklist) {
			if (!found[e]) {
				found[e] = true;
			} else {
				return false;
			}
		}
		
		return true;
	}
}
