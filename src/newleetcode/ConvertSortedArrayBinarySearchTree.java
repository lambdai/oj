//http://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
package newleetcode;

import dyc.TreeNode;

public class ConvertSortedArrayBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null) {
			return null;
		}
		return subArrayToBST(num, 0, num.length-1);
	}

	public TreeNode subArrayToBST(int[] num, int il, int ir) {
		if (il > ir) {
			return null;
		}
		int im = (il + ir) / 2;
		TreeNode n = new TreeNode(num[im]);
		n.left = subArrayToBST(num, il, im - 1);
		n.right = subArrayToBST(num, im + 1, ir);
		return n;
	}

}
