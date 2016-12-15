package lcArraysLinkedListsStrings;
/**
 * From back to start to avoid shifting. Notice m and n are length not index.
 * @author Xuechao
 *
 */
public class MergeSortedArray {
	public void merge(int[] A, int m, int[] B, int n) {
		while ( n-1 >= 0) {
			if ( m == 0 || B[n-1] > A[m-1]) {
				A[m+n-1] = B[n-1];
				n--;
			} else {
				A[m+n-1] = A[m-1];
				m--;
			}
		}
    }
}
