package codingskillandtrivialimplementations;

import java.util.ArrayList;
import java.util.List;
/**
 * deal with single column and single row. find exceeding mid index with a table.
 * @author Xuechao
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList<>();
		if (matrix.length == 0) return ret;
		helper (ret, matrix, 0);
		return ret;
	}

	private void helper (List<Integer> ret, int[][] matrix, int startCol) {
		/*
		 * mid exceeding condition
		 */
		if (startCol > (matrix[0].length-1)/2 || startCol > (matrix.length-1)/2) {
			return;
		} else {
		    if (startCol == matrix[0].length - 1 - startCol) {
		        for (int i = startCol; i <= matrix.length - 1 - startCol; ++i) ret.add(matrix[i][startCol]);
		    } else if (startCol == matrix.length - 1 - startCol){
		        for (int i = startCol; i <= matrix[0].length - 1 - startCol; ++i) ret.add(matrix[startCol][i]);
		    } else {
    			for (int i = startCol; i < matrix[0].length - 1 - startCol; ++i) ret.add(matrix[startCol][i]);
                for (int i = startCol; i < matrix.length - 1 - startCol; ++i) ret.add(matrix[i][matrix[0].length-1-startCol]);
                for (int i = matrix[0].length - 1 - startCol; i > startCol; --i) ret.add(matrix[matrix.length-1-startCol][i]);
                for (int i = matrix.length - 1 - startCol; i > startCol; --i) ret.add(matrix[i][startCol]);
                helper (ret, matrix, startCol + 1);
		    }
		}
	}
}
