//http://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
package newleetcode;

import dyc.TreeNode;

public class SumRootLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return sum(root, 0, 0);
	}

	int sum(TreeNode node, int path, int sum) {

		if (node == null) {
			return sum;
		}

		path = 10 * path + node.val;
		if (node.left == null && node.right == null) {
			return sum + path;
		}
		return sum(node.right, path, sum(node.left, path, sum));
	}
}
