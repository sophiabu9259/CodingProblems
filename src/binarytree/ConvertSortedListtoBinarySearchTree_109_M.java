package binarytree;

import basicstructures.ListNode;
import basicstructures.TreeNode;
/**
 * Flat a BST into a list. Find that the tree and be build from leftmost to rightmost.
 * @author Xuechao
 *
 */
public class ConvertSortedListtoBinarySearchTree_109_M {
	public TreeNode sortedListToBST(ListNode head) {
		// nlogn run time
		int count = 0;
		ListNode temp = head;
		while (temp != null) {
			count ++;
			temp = temp.next;
		}
		
		return helper (head, 0, count - 1);
	}
	
	private TreeNode helper (ListNode head, int start, int end) {
		if (start > end) {
			return null;
		}
		
		int mid = start + (end - start + 1)/2;
		ListNode temp = head;
		for (int i = 0; i < mid; ++i) {
			temp = temp.next;
		}
		int val = temp.val;
		TreeNode ret = new TreeNode(val);
		ret.left = helper (head, start, mid - 1);
		ret.right = helper (head, mid + 1, end);
		return ret;
	}
/*	
	public ListNode rootCursor;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode cursor = head;
        int len = 0;
        while(cursor!=null){
            len += 1;
            cursor = cursor.next;
        }
        rootCursor = head;
        return helper(0,len-1);
    }
    //linear time
    public TreeNode helper(int start, int end){
        if(start > end) return null;
        int median = (start+end)/2;
        TreeNode leftChild = helper(start,median-1);
        TreeNode root = new TreeNode(rootCursor.val);
        rootCursor = rootCursor.next;
        root.left = leftChild;
        root.right = helper(median+1,end);
        return root;
    }
    
    */
}
