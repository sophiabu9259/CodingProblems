package matrix;
/**
 * use typical bs to find "should be" pos, and then targetrow = pos-1. then BS in targetrow. 
 * @author xuechao
 *
 */
public class Search2D {
	public boolean searchMatrix (int[][] matrix, int target) {
		int low = 0;
		int high = matrix.length-1;
		
		while (low <= high) {
			int mid = (low + high) /2;
			int midNum = matrix[mid][0];
			if (target == midNum) return true;
			else if (target < midNum) high = mid-1;
			else low = mid+1;
		}
		if (low == 0) return false;
		
		int targetRow = low - 1;
		
		low = 0;
		high = matrix[targetRow].length-1;
		
		while (low <= high) {
			int mid = (low + high) /2;
			int midNum = matrix[targetRow][mid];
			if (target == midNum) return true;
			else if (target < midNum) high = mid - 1;
			else low = mid + 1;
		}
		
		return false;
	}
}
