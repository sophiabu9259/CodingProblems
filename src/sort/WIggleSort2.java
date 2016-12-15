package sort;

import java.util.Arrays;

public class WIggleSort2 {

	    public void wiggleSort(int[] nums) {
	        Arrays.sort (nums);
	        int len = nums.length;
	        int mid = nums.length%2 == 0? len/2 - 1 : len/2;
	        
	        int[] temp = new int[len];
	        int index = 0;
	        for (int i = 0; i <= mid; ++i) {
	            temp[index] = nums[i];
	            index += 2;
	        }
	        
	        index = 1;
	        for (int i = mid + 1; i < len; ++i) {
	            temp[index] = nums[i];
	            index += 2;
	        }
	        
	        for (int i = 0; i < len; ++i) {
	            nums[i] = temp[i];
	        }
	        
	    }

	public static void main (String[] args) {
		WIggleSort2 w = new WIggleSort2();

		int[] test = {1, 1,1,1,1,1,1,3, 2, 2, 3, 1};
		
		w.wiggleSort(test);
		
		System.out.println(Arrays.toString(test));
		
		
	}
}
