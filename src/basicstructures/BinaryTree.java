package basicstructures;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTree {
		
	void preorderRecursion (TreeNode root, List<Integer> ret) {
		if (root != null) {
			ret.add(root.val);
			preorderRecursion (root.left, ret);
			preorderRecursion (root.right, ret);
		}
		
	}
	
	void postorderRecursion (TreeNode root, List<Integer> ret) {
		if (root != null) {
			postorderRecursion(root.left, ret);
			postorderRecursion(root.right, ret);
			ret.add(root.val);
		}
	}
	
	void inorderRecursion (TreeNode root, List<Integer> ret) {
		if (root != null) {
			inorderRecursion (root.left, ret);
			ret.add(root.val);
			inorderRecursion (root.right, ret);
		}
	}
	
	void preorderIter (TreeNode root,List<Integer> ret) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode top = stack.pop();
			ret.add (top.val);
			if (top.right != null) {
				stack.push(top.right);
			}
			
			if (top.left != null) {
				stack.push(top.left);
			}
		}
		
	}
	
	void inorderIter (TreeNode root, List<Integer> ret) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;

		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				ret.add(cur.val);
				cur = cur.right;
			}
		}
	}
	
	void postorderIter (TreeNode root, List<Integer> ret) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		TreeNode prev = null;

		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push (cur);
				prev = cur;
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (cur.right == null || cur.right == prev) { //this part
					ret.add(cur.val);
					prev = cur;
					cur = null;
				} else {
					stack.push(cur);
					cur = cur.right;
				}
			}
		}
	}
	
	
	
	
	
	/*
	 * --------------------------------------------------------------------------------------------------------------------------------------------
	 */
	
	public static void main (String[] args) {
		List<Integer> ret = new ArrayList<>();
		
		TreeNode root = new TreeNode(0);
		
		root.left = new TreeNode (1);
		root.right = new TreeNode (2);
		TreeNode l = root.left;
		TreeNode r = root.right;
		
		l.left = new TreeNode (3);
		l.right = new TreeNode (4);
		l = l.left;
		l.left = new TreeNode (7);
		
		r.left = new TreeNode (5);
		r.right = new TreeNode (6);
		
		Integer[] in = {7,3,1,4,0,5,2,6};
		Integer[] pre = {0,1,3,7,4,2,5,6};
		Integer[] post =  {7,3,4,1,5,6,2,0};
		List<Integer> inorderResult = new ArrayList<Integer> (Arrays.asList(in));
		List<Integer> preorderResult = new ArrayList<Integer> (Arrays.asList(pre));
		List<Integer> postorderResult = new ArrayList<Integer> (Arrays.asList(post));
		
		BinaryTree bt = new BinaryTree();
		
		bt.preorderRecursion (root, ret);
		System.out.println("Preorder recursion: " + ret.equals(preorderResult));
		
		ret = new ArrayList<>();
		bt.inorderRecursion(root, ret);
		System.out.println("Inorder recursion: " + ret.equals(inorderResult));
		
		ret = new ArrayList<>();
		bt.postorderRecursion(root, ret);
		System.out.println("Postorder recursion: " + ret.equals(postorderResult));
		
		ret = new ArrayList<>();
		bt.preorderIter(root, ret);
		System.out.println("Preorder iteration: " + ret.equals(preorderResult));
		
		ret = new ArrayList<>();
		bt.inorderIter(root, ret);
		System.out.println("Inorder Iteration: " + ret.equals(inorderResult));
		
		ret = new ArrayList<>();
		bt.postorderIter(root, ret);
		System.out.println("Postorder Iteration: " + ret.equals(postorderResult));
	}
	
	
	
	
	
	
	
	
	
	
	
}
