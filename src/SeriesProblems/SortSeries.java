package SeriesProblems;

import java.util.Arrays;

public class SortSeries {
	
	public static void main (String[] args) {
		ArraySort.demo();
	}
	
	static class LinkedListSort {
		
	}
	
	static class ArraySort{
		static void insertionSort (int[] arr) {
			for (int i = 1; i  < arr.length; ++i) {
				int key = arr[i];
				int j = i - 1;
				for (; j >= 0 && arr[j] > key; --j) {
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = key;
			}
		}
		
		static void demo() {
			int[] arr= {
					5, 4, 3, 2, 1
			};
			insertionSort(arr);
			System.out.println(Arrays.toString(arr));
		}
	}
}
