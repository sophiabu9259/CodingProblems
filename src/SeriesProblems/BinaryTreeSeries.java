package SeriesProblems;

import java.util.Stack;

import basicstructures.TreeNode;
/**
 * 1. Binary Tree Iterator
 * 2. Longest Consecutive Sequence
 * 
 * @author xuechao
 *
 */
public class BinaryTreeSeries {
	/**
	 * Use a stack to store node values.
	 * @author xuechao
	 *
	 */
	static class BSTIterator {
		
		Stack<TreeNode> stack;
		
		public BSTIterator(TreeNode root) {
			this.stack = new Stack<>();
			TreeNode p = root;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !this.stack.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode top = this.stack.pop();
			int ret = top.val;
			TreeNode p = top.right;
		    while (p != null) {
		    	this.stack.push(p);
		    	p = p.left;
		    }
			return ret;
		}
	}
	
	class BinaryTreeLongestConsecutiveSequence_298_M {
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
}
