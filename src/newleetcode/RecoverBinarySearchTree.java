//http://oj.leetcode.com/problems/recover-binary-search-tree/
package newleetcode;

import dyc.TreeNode;

public class RecoverBinarySearchTree {

	TreeNode[] suspicious;
	TreeNode[] parent;
	int index;

	public void recoverTree(TreeNode root) {
		suspicious = new TreeNode[2];
		// parent = new TreeNode[2];
		searchTree(null, root, suspicious);
		// findParent(null, root,suspicious[0]);
		swap(suspicious[0], suspicious[1]);
	}

	private void swap(TreeNode n0, TreeNode n1) {
		int temp = n1.val;
		n1.val = n0.val;
		n0.val = temp;
	}

	private void findParent(TreeNode parent, TreeNode current, TreeNode toFind) {
		if (current == toFind) {
			this.parent[0] = parent;
			return;
		}
		if (toFind.val > current.val) {
			findParent(current, current.right, toFind);
		} else {
			findParent(current, current.left, toFind);
		}
	}

	private TreeNode searchTree(TreeNode pre, TreeNode node,
			TreeNode[] suspicious) {
		if (index > 1) {
			return null;
		}
		if (node.left != null) {
			pre = searchTree(pre, node.left, suspicious);
		}
		if (index == 0) {
			if (pre != null && pre.val > node.val) {
				suspicious[index++] = pre;
				suspicious[index] = node;
				// this.parent[index] = parent;
			}

		} else if (index == 1) {
			if (pre.val > node.val) {
				suspicious[index++] = node;
				// this.parent[index] = node;
			}
		} else {
			return null;
		}
		if (node.right != null) {
			return searchTree(node, node.right, suspicious);
		} else {
			return node;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		n0.left = n1;
		new RecoverBinarySearchTree().recoverTree(n0);
		return;
	}

}
