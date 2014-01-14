//http://oj.leetcode.com/problems/symmetric-tree/
package newleetcode;

import dyc.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left != null && right != null) {
			if (left.val == right.val) {
				return isSymmetric(left.left, right.right)
						&& isSymmetric(left.right, right.left);
			}
			return false;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
