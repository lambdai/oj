//http://oj.leetcode.com/problems/validate-binary-search-tree/
package newleetcode;

import dyc.TreeNode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return inRange(root.left, Integer.MIN_VALUE, root.val-1) && inRange(root.right, root.val+1, Integer.MAX_VALUE);
	}

	private boolean inRange(TreeNode node, int minValue, int maxValue) {
		if (node == null) { return true; }
		return node.val <= maxValue && node.val >= minValue && inRange(node.left, minValue, node.val-1) && inRange(node.right, node.val+1, maxValue );
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
