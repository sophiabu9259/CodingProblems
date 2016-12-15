package binarytree;

import basicstructures.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal_106_M {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        //corner cases
		if (inorder == null || postorder == null) {
			return null;
		}
		
		if (inorder.length != postorder.length) {
			return null;
		}
		return helper (inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
	
	private TreeNode helper (int[] inorder, int pStart, int pEnd, int[] postorder, int qStart, int qEnd) {
		if (qStart > qEnd) {
			return null;
		}
		
		TreeNode root = new TreeNode (postorder[qEnd]);
		int mid = pStart;
		for (; mid <= pEnd; ++mid) {
			if (inorder[mid] == root.val) {
				break;
			}
		}
		
		int leftLen = mid - pStart;
		root.left = helper (inorder, pStart, mid - 1, postorder, qStart, qStart + leftLen - 1);
		root.right = helper (inorder, mid + 1, pEnd, postorder, qStart + leftLen, qEnd);
		return root;
	}
}
