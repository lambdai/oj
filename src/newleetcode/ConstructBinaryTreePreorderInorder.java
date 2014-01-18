//http://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
package newleetcode;

import dyc.TreeNode;

public class ConstructBinaryTreePreorderInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = preorder.length;
		TreeNode root = buildTree(preorder, 0, len - 1, inorder, 0, len - 1);
		return root;
	}

	TreeNode buildTree(int[] preorder, int lp, int rp, int[] inorder, int li,
			int ri) {
		if (lp > rp) {
			return null;
		}
		int val = preorder[lp];
		TreeNode node = new TreeNode(val);
		int posOfNode = find(val, inorder, li, ri);
		int leftLen = posOfNode - li;
		node.left = buildTree(preorder, lp + 1, lp + leftLen, inorder, li,
				posOfNode - 1);
		node.right = buildTree(preorder, lp + leftLen + 1, rp, inorder,
				posOfNode + 1, ri);
		return node;
	}

	int find(int val, int[] inorder, int li, int ri) {
		for (int i = li; i <= ri; ++i) {
			if (val == inorder[i]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
