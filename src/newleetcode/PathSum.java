//http://oj.leetcode.com/problems/path-sum/
package newleetcode;

import dyc.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (sum == root.val && root.left == null && root.right == null) {
			return true;
		}

		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}
}
