package binarytree;


import basicstructures.TreeNode;
/**
 * Use a helper function to find target value. Update previous length and MAX len.
 * @author xuechao
 *
 */
public class BinaryTreeLongestConsecutiveSequence_298_M {
	public int longestConsecutive(TreeNode root) {
		if (root == null) return 0;
		int[] max = new int[1];
		max[0] = 1;
		helper (root.left, root.val + 1, 1, max);
		helper (root.right, root.val + 1, 1, max);
		return max[0];
	}
	
	public void helper (TreeNode root, int target, int preLen, int[] max) {
		if (root == null) return;
		if (root.val == target) {
			preLen ++;
			max[0] = Math.max(max[0], preLen);
		} else {
			preLen = 1;
		}
		helper (root.left, root.val + 1, preLen, max);
		helper (root.right, root.val+1, preLen, max);
	}
}
