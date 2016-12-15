package lcArraysLinkedListsStrings;

/**
 * Given a m x n matrix, 
 * if an element is 0, set its entire row and column to 0. 
 * Do it in place.?
 * @author Xuechao
 *
 */
public class SetZeroMatrix {
	public void setZeroes(int[][] matrix) {
		 /**
         * Scan whole matrix. Record 0 coordinates.
         * in place?
         * Use first row or first column to record.
         * Careful when there is no zero in first row or col
         */
		
		//input check
		if(matrix.length == 0) return;
		int m = matrix.length, n = matrix[0].length;
		boolean firstRowHasZero = false, firstColHasZero = false;

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0){
					if(i==0) firstRowHasZero = true;
				    if(j==0) firstColHasZero = true;
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(matrix[i][0]==0 || matrix[0][j]==0)
					matrix[i][j] = 0;
			}
		}
		
		if(firstRowHasZero){
		    for(int i = 0; i < n; i ++)
		        matrix[0][i] = 0;
		}
		
		if(firstColHasZero){
		    for(int j = 0; j < m ; j ++){
		        matrix[j][0] = 0;
		    }
		}
    }
}
