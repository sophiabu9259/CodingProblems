package dynamicprogramming;
/**
 * longest palindrome is not necessarily in the final cut list.
 * @author Xuechao
 *
 */
public class PalindromePartitionII {
	public int minCut(String s) {
        char[] arr = s.toCharArray();
        int[] f = new int[arr.length+1];
        // f[x] stands for on x+1 position, min cut for that position. (chunk amount - 1)
        // when the palindrome reaches position 0, that means we dont need previous cut.
        // set it to -1 because we want to update palindrome's right edge with previous min cut +1,
        // position 0 has no left predecessor, and we dont need any cut from 0 to the palindrome's right edge
        // set it to -1 so when only one chars or one palindrome in the string, we need 0 cuts. (chunk amount 1)
        for (int i = -1; i < arr.length; ++i) {
        	f[i+1] = i;
        }
        
        /* for each position, reach out to both direction, detect palindrome in
         * even or odd pattern (notice boundary checks), when finding a palindrome, 
         * update its rightmost position with this palindrome's predecessor's string's
         * min cut + 1. 1 means the palindrome we found.
         */
        for (int i = 0; i < arr.length; ++i) {
        	for (int j = 0; i - j >= 0 && i+j < arr.length && (arr[i+j] == arr[i-j]); ++j) {
        		f[i+j+1] = Math.min(f[i+j+1], f[i-j]+1);
        	}
        	for (int j = 0; i - j >= 0 && i+j+1 < arr.length && (arr[i+1+j] == arr[i-j]); ++j) {
        		f[i+j+2] = Math.min(f[i+j+2], f[i-j]+1);
        	}
        }
        
        return f[arr.length];
    }
}
