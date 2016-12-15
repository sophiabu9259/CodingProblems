package binarytree;

import basicstructures.TreeNode;
/**
 * 1. preorder's first is the root val.
 * 2. because there is no duplicate, go find root val in inorder. Record and get left subtree length and right sub tree length.
 * 3. Write a helper with the boundaries we found.
 * @author Xuechao
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_105_M {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		
		if (preorder.length != inorder.length) {
			return null;
		}
		
		return helper (preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	private TreeNode helper (int[] preorder, int pStart, int pEnd, int[] inorder, int qStart, int qEnd) {
		if (pStart > pEnd) {
			return null;
		} 
		
		TreeNode root = new TreeNode (preorder[pStart]);
		int i = qStart;
		for (; i <= qEnd; ++i) {
			if (inorder[i] == root.val) {
				break;
			}
 		}
		int lenLeft = i - qStart;
		root.left = helper (preorder, pStart + 1, pStart + lenLeft, inorder, qStart, i - 1);
		root.right = helper (preorder, pStart + lenLeft + 1, pEnd, inorder, i + 1, qEnd);
		return root;
	}
}
