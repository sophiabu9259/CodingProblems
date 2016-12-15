package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import basicstructures.TreeNode;

public class SerializeandDeserializeBinaryTree_297_H {
	// Encodes a tree to a single string.
	static public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode top = q.poll();
			if (top == null) {
				sb.append("nnnnnnnn");
			} else {
				String hex = Integer.toHexString(top.val);
				int addZero = 8 - hex.length();
				for (int i = 0; i < addZero; ++i) {
					sb.append('0');
				}
				sb.append(hex);
				q.offer(top.left);
				q.offer(top.right);
			}
		}

		return sb.toString();
	}

	// Decodes your encoded data to tree.
	static public TreeNode deserialize(String data) {
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = null;
		int index = 0;
		if (data != null && data.length() != 0) {
			if (data.substring(0,8) .equals("nnnnnnnn")) return null;
			root = new TreeNode ((int)Long.parseLong(data.substring(0,8), 16));
			index += 8;
		}
		q.offer(root);

		while (index < data.length()) {
			TreeNode top = q.poll();
			String temp = data.substring(index, index + 8);
			index += 8;

			if (!temp.equals("nnnnnnnn")) {
				top.left = new TreeNode ((int)Long.parseLong(data.substring(0,8), 16));
				q.offer(top.left);
			}


			if (index >= data.length()) {
				break;
			}
			temp = data.substring(index, index + 8);
			index += 8;
			if (!temp.equals("ffffffff")) {
				top.right = new TreeNode(Integer.valueOf(temp, 16));
				q.offer(top.right);
			}

		}

		return root;

	}

	public static void main (String[] args) {
		TreeNode root = new TreeNode (-1);
		root.left = null;
		root.right = new TreeNode (2);

		TreeNode test = deserialize (serialize (root));

		//bfs view
	}
}
