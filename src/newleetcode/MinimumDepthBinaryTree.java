//http://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
package newleetcode;

import dyc.TreeNode;

public class MinimumDepthBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int dl = -1, dr = -11;
		if (root.left != null) {
			dl = minDepth(root.left);
		}
		if (root.right != null) {
			dr = minDepth(root.right);
		}
		int max = dl > dr ? dl : dr;
		if (max == -1) {
			return 1;
		}
		int min = dl + dr - max;
		if (min < 0) {
			return 1 + max;
		}
		return 1 + min;
	}
}