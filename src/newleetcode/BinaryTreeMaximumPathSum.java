//http://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
package newleetcode;

import dyc.TreeNode;

public class BinaryTreeMaximumPathSum {
	int max = 0;
	public int maxPathSum(TreeNode root) {
		max = root.val;
		decendMax(root);
		return max;
	}
	int decendMax(TreeNode node) {
		if (node == null) { return 0; }
		int leftMax = decendMax(node.left);
		int rightMax = decendMax(node.right);
		int localMax = node.val + leftMax + rightMax;
		if (localMax > max) {
			max = localMax;
		}
		int maxBranch = leftMax > rightMax? leftMax + node.val: rightMax + node.val;
		return maxBranch > 0 ? maxBranch : 0;
	}

}
