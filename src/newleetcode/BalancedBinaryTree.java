//http://oj.leetcode.com/problems/balanced-binary-tree/
package newleetcode;

import dyc.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		int result[] = new int[2];
		result[1] = 1;
		depthAndBalance(root, result);
		return result[1] == 1;
	}

	void depthAndBalance(TreeNode node, int[] result) {
		if (node == null) {
			result[0] = 0;
			result[1] = 1;
			return;
		}

		depthAndBalance(node.left, result);
		if (result[1] == 0) {
			return;
		}
		int lDepth = result[0];
		depthAndBalance(node.right, result);
		if (result[1] == 0) {
			return;
		}
		result[1] = lDepth > result[0] + 1 || lDepth < result[0] - 1 ? 0 : 1;
		result[0] = lDepth > result[0] ? lDepth + 1 : result[0] + 1;
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
