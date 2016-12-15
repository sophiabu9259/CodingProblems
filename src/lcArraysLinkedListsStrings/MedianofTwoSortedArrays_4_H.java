package lcArraysLinkedListsStrings;

public class MedianofTwoSortedArrays_4_H {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		/* Challenge 1: find correct index
		 * final result want a median even m + n % 2 == 0. So we need find a left median and a right median for this case.
		 * if x is odd, (x + 1) /2 == (x + 2) /2 == x/2 + 1
		 * if x is even, (x + 1) /2 == (x + 2) /2 - 1 == x/2
		 */
		int leftMid = (m + n + 1) / 2;
		int rightMid = (m + n + 2) / 2;
		/*
		 * Challenge 2: log(m + n) runtime.
		 * Thats definitely binary search.
		 */
		return (helper (nums1, 0, nums2, 0, leftMid) + helper (nums1, 0, nums2, 0, rightMid) )/2.0;
	}
	
	private int helper (int[] nums1, int start1, int[] nums2, int start2, int topK) {
		
		
		/*
		 * Recursion breaking condition:
		 * topK == 1
		 * Notice one of the array may be eliminated up. Return the other.
		 */
		if (topK == 1) {
		    if (start1 > nums1.length - 1) return nums2[start2];
		    else if (start2 > nums2.length - 1) return nums1[start1];
		    else return Math.min(nums1[start1], nums2[start2]);
		}
		
		/*
		 * If one of the two halfs cannot satisfy the target length (topK/2), keep the shortening half, for the other length-enough half surely fall into topK segment.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		 */
		if (start1 + topK/2 - 1 > nums1.length - 1) {
			return helper (nums1, start1, nums2, start2 + topK/2, topK - topK/2);
		}
		
		if (start2 + topK/2 - 1 > nums2.length -1) {
			return helper (nums1, start1 + topK/2, nums2, start2, topK - topK/2);
		}
		/*
		 * Length is enough, eliminate by comparing last element.
		 */
		if (nums1[start1 + topK/2 -1] < nums2[start2 + topK/2 -1]) {
			return helper (nums1, start1 + topK/2, nums2, start2, topK - topK/2);
		} else {
			return helper (nums1, start1, nums2, start2 + topK/2, topK - topK/2);  
		}
		
	}
}
