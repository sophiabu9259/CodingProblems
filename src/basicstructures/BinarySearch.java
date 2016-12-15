package basicstructures;

import java.util.Arrays;

public class BinarySearch {
	
	public int binarysearch (int[] arr, int target) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] < target) lo = mid + 1;
			else hi = mid;
		}

		return lo;
	}
	
	public int binarysearchRecursion (int[] arr, int target, int hi, int lo) {
		if (lo >= hi) return lo;
		int mid = lo + (hi - lo) / 2;
		if (arr[mid] == target) return mid;
		if (target > arr[mid]) return binarysearchRecursion (arr, target, hi, lo + 1);
		return binarysearchRecursion (arr, target, mid, lo);
		
	}
	
	public int binarysearchSame (int[] arr, int target) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {
			int mid = lo + (hi - lo) /2;
			if (arr[mid] >= target) hi = mid;
			else lo = mid + 1;
		}

		return lo;
	}

	/*
	 * -----------------------------------------------------
	 */

	 public static void main (String[] args) {
	 	int[] arr1 = {};
	 	int[] arr2 = {1};
	 	int[] arr3 = {1,2};
	 	int[] arr4 = {1,2,3};
	 	
	 	int[][] testsuit1 = {arr1, arr2, arr3, arr4};
	 	int[] targetsuit1 = {1,2,2,3};
	 	int[] resultsuit1 = {0, 0, 1, 2};
	 	BinarySearch o = new BinarySearch();
	 	System.out.println("BS ITER: ");
	 	for (int i = 0; i < testsuit1.length; ++i) {
	 		System.out.println("Testing: " + Arrays.toString(testsuit1[i]) + " finding "+ targetsuit1[i] +  "... " + (resultsuit1[i] == o.binarysearch(testsuit1[i], targetsuit1[i])));
	 	}
	 	System.out.println("\nBS RECUR: ");
	 	for (int i = 0; i < testsuit1.length; ++i) {
	 		System.out.println("Testing: " + Arrays.toString(testsuit1[i]) + " finding "+ targetsuit1[i] +  "... " + (resultsuit1[i] == o.binarysearchRecursion(testsuit1[i], targetsuit1[i], testsuit1[i].length - 1, 0)));
	 	}
	 	

	 	int[] arr5 = {1,2,3,3,3,3,4};
	 	int[] arr6 = {1,1,1,2,3};
	 	int[] arr7 = {1,2,3,4,4,4};
	 	
	 	int[][] testsuite2 = {arr5, arr6, arr7};
	 	int[] targetsuite2 = {3,1,4};
	 	int[] resultsuite2 = {2, 0, 3};
	 	
	 	System.out.println("BS with same values: finding leftmost");
	 	System.out.println("\nBS SAME: ");
	 	for (int i = 0; i < testsuite2.length; ++i) {
	 		System.out.println("Testing: " + Arrays.toString(testsuite2[i]) + " finding "+ targetsuite2[i] +  "... " + (resultsuite2[i] == o.binarysearchSame(testsuite2[i], targetsuite2[i])));
	 	}
	 	
  	 }
}
