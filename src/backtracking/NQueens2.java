package backtracking;

public class NQueens2 {
	public int totalNQueens(int n) {
        int[] ret = new int[1];
        backtracking (ret, new int[n][n], 0);
        return ret[0];
    }
    
    public void backtracking (int[] ret, int[][] temp, int row) {
        if (row == temp.length) {
            ret[0]++;
        } else {
            for (int i = 0; i < temp.length; i++) {
                if (temp[row][i] == 0) {
                    modify(temp, row, i, 1);
                    temp[row][i] = -1;
                    backtracking (ret, temp, row+1);
                    modify (temp, row, i, -1);
                    temp[row][i] = 0;
                }
            }
        }
    }
    
    public void modify (int[][] temp, int row, int col, int mod) {
        for (int i = 0; i < temp.length; i++) {
            temp[row][i]+=mod;
            temp[i][col]+=mod;
        }
        
        for (int i = row, j = col; i >= 0 && j >= 0; i--,j--){
            temp[i][j]+=mod;
        }
        
        for (int i = row, j = col; i >= 0 && j < temp.length; i--, j++) {
            temp[i][j]+=mod;
        }
        
        for (int i = row, j = col; i < temp.length && j >= 0; i++,j--) {
            temp[i][j]+=mod;
        }
        
        for (int i = row, j = col; i < temp.length && j < temp.length; i++, j++) {
            temp[i][j]+=mod;
        }
    }
}
