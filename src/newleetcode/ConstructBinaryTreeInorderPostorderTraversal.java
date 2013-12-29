//http://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
package newleetcode;

import dyc.TreeNode;

public class ConstructBinaryTreeInorderPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null) {
			return null;
		}
		return buildNode(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	public TreeNode buildNode(int[] inorder, int il1, int ir1, int[] postorder,
			int il2, int ir2) {

		if (il1 > ir1) {
			return null;
		}
		int val = postorder[ir2];
		TreeNode n = new TreeNode(val);
		int ival = -1;// isuc = -1;
		for (int i = il1; i <= ir1; ++i) {
			if (inorder[i] == val) {
				ival = i;
				// System.out.println(" find i" + ival);
				break;
			}
		}

		if (ival >= 0) {
			n.left = buildNode(inorder, il1, ival - 1, postorder, il2, il2
					+ (ival - 1 - il1));
			n.right = buildNode(inorder, ival + 1, ir1, postorder, ir2 - 1
					- (ir1 - ival - 1), ir2 - 1);
		}
		return n;
	}

	public static void main(String args[]) {
		new ConstructBinaryTreeInorderPostorderTraversal().buildTree(new int[] {
				1, 2 }, new int[] { 2, 1 });
	}

}
