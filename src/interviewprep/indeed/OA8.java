package interviewprep.indeed;

import java.util.Scanner;

public class OA8 {
	/**
	 * one array. one threshhold T. get the maximum subarray-sum
	 */
	public static void test(String input) {
		Scanner myscanner = new Scanner (input);
		int count = myscanner.nextInt();
		int threshhold = myscanner.nextInt();
		int[] arr = new int[count];
		
		for (int i = 0; i < count; ++i) {
			arr[i] = myscanner.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		int fast = 0;
		int slow = 0;
		int sum = 0;
		
		while (fast < count) {
			sum += arr[fast];
			fast++;
			
			while (sum > threshhold) {
				sum -= arr[slow];
				slow++;
			}
			
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
	}
	
	public static void main (String[] args) {
		String test1 = "5 10 3 3 5 1 7";
		test(test1);
		String test2 = "3 1 4 8 2";
		test(test2);
	}
}
