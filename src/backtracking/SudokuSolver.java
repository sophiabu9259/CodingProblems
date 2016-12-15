package backtracking;
/**
 * Don't use void helper. Use boolean helper. Only for '.' positions, try from '1' to '9'. If valid, try and recursion in.
 * if '1' to '9' all failed vailidation, returen false, stop this branch.
 * 
 * @author xuechao
 *
 */
public class SudokuSolver {
	boolean[][] checkCol;
	boolean[][] checkRow;
	boolean[][][] checkSub;
	boolean solved = false;
	
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		helper (board);
	}
	
	public boolean helper (char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int a = 1; a <= 9; a++) {
						if (isValid(board, a, i, j)){
							board[i][j] = (char) (a + '0');
							if (helper (board)) {
								return true;
							}
							board[i][j] = '.';
						}		
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isValid(char[][] board, int a, int row, int col) {
		
		for ( int i = 0; i < 9; i ++) {
			if (board[row][i] == (char) (a + '0') || board[i][col] == (char) (a + '0')) {
				return false;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row/3*3+i][col/3*3+j] == (char) (a+'0'))
					return false;
			}
		}
		
		return true;
	}
	
	public void solveSudoku_backtracking(char[][] board) {
		checkCol = new boolean[9][9];
		checkRow = new boolean[9][9];
		checkSub = new boolean[3][3][9];
		//to do...
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					checkRow[i][board[i][j]-'0'-1] = true;
					checkCol[j][board[i][j]-'0'-1] = true;
					checkSub[i/3][j/3][board[i][j]-'0'-1] = true;
				}
			}
		}
		
		backtracking (board, 0, 0);
    }
	
	private void backtracking (char[][] board, int row, int start) {
		if (!solved) {
			if (row == 9) {
				if (checkAll(board)){
					System.out.println("solved");
					solved = true;
				}
				else System.out.println("     failed");
				
				for (char[] a : board) {
					for (char c : a) {
						System.out.print(c + " ");
					}
					System.out.println();
				}
				
				return;
			} else {
					for (char c : board[0]) {
						System.out.print(c + " ");
					}
					System.out.println();
				for (int i = start; i < 9; i++) {
					if (board[row][i] == '.') {
						for (int attempt = 1; attempt < 10; attempt++) {
							if (!checkCol[i][attempt-1] && !checkRow[row][attempt-1] && !checkSub[row/3][i/3][attempt-1]) {
								board[row][i] = (char) (attempt + '0');
								checkCol[i][attempt-1] = true;
								checkRow[row][attempt-1] = true;
								checkSub[row/3][i/3][attempt-1] = true;
								backtracking (board, row, start+1);
								if (!solved) {
									checkCol[i][attempt-1] = false;
									checkRow[row][attempt-1] = false;
									checkSub[row/3][i/3][attempt-1] = false;
									board[row][i] = '.'; 
								}
							}
						}
					}
					if (i == 8) {
						if (checkThisRow(board[row]))
							backtracking (board, row+1, 0);
					}
				}
			}
		}
	}
	
	private boolean checkThisRow(char[] row) {
			for (char c : row) {
				if (c == '.') return false;
			}
		return true;
	}
	
	private boolean checkAll(char[][] board) {
		for (char[] a : board) {
			for (char c : a) {
				if (c == '.') return false;
			}
		}
		return true;
	}
	
	public void solveSudokuAnySize(char[][] board) {
		checkCol = new boolean[board.length][board[0].length];
		checkRow = new boolean[board.length][board[0].length];
		checkSub = new boolean[(int) Math.sqrt(board.length)][(int) Math.sqrt(board.length)][board[0].length];
		//to do...
    }
	
	
}
