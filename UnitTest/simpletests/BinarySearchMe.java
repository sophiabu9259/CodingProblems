package simpletests;
/**
 * typical binary search will return "should be" position.
 * @author xuechao
 *
 */
public class BinarySearchMe {
	public int binarySearch (int[] input, int target) {
		int low = 0;
		int high = input.length - 1;
		
		while (low <= high) {
			int mid = (low + high) /2;
			if (input[mid] == target) return mid;
			else if (target < input[mid]) high = mid-1;
			else low = mid+1;
		}
		return low; // or -1 indicates not found
	}
}
