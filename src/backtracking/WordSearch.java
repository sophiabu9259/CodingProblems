package backtracking;
/**
 * search board for starting char. then backtrack only with 4 directions. Use a boolean matrix to avoid reusing a char.
 * @author xuechao
 *
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
        //edeg cases
		if (word == null || word.length() == 0) return true;
		if (board.length == 0 || board[0].length == 0) return false; 
		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (backtracking(board,i,j,word,0, used)) {
						return true;
					}
				}
			}
		}
		return false;
    }
	
	private boolean backtracking (char[][] board, int row, int col, String target, int targetIndex, boolean[][] used) {
		if (row < 0 || col < 0 || row > board.length-1 || col > board[0].length-1){
			return false;
		}
		if (board[row][col] == target.charAt(targetIndex)) {
			if (targetIndex == target.length()-1) return true;
			used[row][col] = true;
			if (col > 0 && !used[row][col-1] && backtracking (board, row, col-1, target, targetIndex+1, used)) return true;
			if (col < board[0].length-1 && !used[row][col+1] && backtracking (board, row, col+1, target, targetIndex+1, used)) return true;
			if (row > 0 && !used[row-1][col] &&backtracking (board, row-1, col, target, targetIndex+1, used)) return true;
			if (row < board.length-1 && !used[row+1][col] && backtracking (board, row+1, col, target, targetIndex+1,used)) return true;
			used[row][col] = false;
		}	
		return false;
	}
}
