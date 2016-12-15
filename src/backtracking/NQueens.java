package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * for each row, test every pos with Queen, occupying horizontal and vertical and diagonal crossing paths. Then go to next row and test non occupied positions. 
 * Recover all occupied places after finishing one position of queen testing. Use int to represent occupation: increments meaning occupied, decrements meaning recovering. Skip
 *  -1 places where -1 means Queen position.
 * @author xuechao
 *
 */
public class NQueens {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ret = new ArrayList<>();
		backtracking (ret, new int[n][n], 0);
		return ret;
    }
	
	private void backtracking (List<List<String>> ret, int[][] temp, int row) {
		if (row == temp.length) {
			List<String> newTemp = new ArrayList<>();
			for (int[] e : temp) {
				StringBuilder myStrB = new StringBuilder();
				for (int i : e) {
					if ( i == -1 ) {
						myStrB.append("Q");
					} else {
						myStrB.append(".");
					}
				}
				newTemp.add(myStrB.toString());
			}
			ret.add(newTemp);
		} else {
			for (int i = 0; i < temp[0].length; i++) {
				if (temp[row][i] == 0) {
					occupy (temp, row, i);
					temp[row][i] = -1;
					backtracking(ret, temp, row+1);
					recover (temp, row, i);
					temp[row][i]  = 0;
				}
			}
		}
	}
	
	private void occupy (int[][] temp, int row, int col) {
		for (int i = 0; i < temp.length; i++) {
			temp[row][i] ++;
			temp[i][col] ++;
		}
		
		for (int i = row, j = col; i >= 0 && j >= 0; i--,j--) {
			temp[i][j] ++;
		}
		
		for (int i = row, j = col; i < temp.length && j >= 0; i++, j--) {
			temp[i][j] ++;
		}
		
		for (int i = row, j = col; i < temp.length && j < temp.length; i++, j++) {
			temp[i][j] ++;
		}
		
		for (int i = row, j = col; i >= 0 && j < temp.length; i--,j++) {
			temp[i][j] ++;
		}
	}
	
	private void recover (int[][] temp, int row, int col) {
		for (int i = 0; i < temp.length; i++) {
			temp[row][i] --;
			temp[i][col] --;
		}
		
		for (int i = row, j = col; i >= 0 && j >= 0; i--,j--) {
			temp[i][j] --;
		}
		
		for (int i = row, j = col; i < temp.length && j >= 0; i++, j--) {
			temp[i][j] --;
		}
		
		for (int i = row, j = col; i < temp.length && j < temp.length; i++, j++) {
			temp[i][j] --;
		}
		
		for (int i = row, j = col; i >= 0 && j < temp.length; i--,j++) {
			temp[i][j] --;
		}
	}
}
