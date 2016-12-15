package binarytree;

import basicstructures.TreeNode;
/**
 * Notice balance. mid should be the righter one.
 * @author Xuechao
 *
 */
public class ConvertSortedArraytoBinarySearchTree_108_M {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		return helper (nums, 0, nums.length - 1);
	}
	
	private TreeNode helper (int[] nums, int start, int end) {
		if (end == start) {
			return new TreeNode (nums[start]);
		} else if (start > end) {
			return null;
		} else {
			int mid = start + (end - start + 1)/2;
			TreeNode temp = new TreeNode (nums[mid]);
			temp.left = helper (nums, start, mid - 1);
			temp.right = helper (nums, mid + 1, end);
			return temp;
		}
	}
}
