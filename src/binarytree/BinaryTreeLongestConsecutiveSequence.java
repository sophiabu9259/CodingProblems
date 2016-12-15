package binarytree;


import basicstructures.TreeNode;
public class BinaryTreeLongestConsecutiveSequence {
	/**
	* Use dfs, cut/update on not meeting the target value.
	* use an array of int to pass down the max value. or use a global/class variable
	*
	*/
	public int longestConsecutive (TreeNode root) {
		if (root == null) return 0;
		int[] max = {0};
		util (root, root.val, 0, max);
		return max[0];

	}

	public void util (TreeNode root, int target, int len, int[] max) {
		if (root != null ) {
			if (root.val == target) {
				len++;
				max[0] = Math.max (len, max[0]);
			} else {
				len = 1;
			}
			util (root.left, root.val + 1, len, max);
			util (root.right, root.val + 1, len, max);
		}

	}
}
