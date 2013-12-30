//http://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
package newleetcode;

import java.util.ArrayList;
import java.util.Stack;

import dyc.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			int i = 0;
			while (!stack.empty()) {
				stack = zigzagNthLevel(i, stack, res);
				i++;
			}
		}
		return res;
	}

	public Stack<TreeNode> zigzagNthLevel(int level, Stack<TreeNode> s,
			ArrayList<ArrayList<Integer>> l) {
		Stack<TreeNode> currentNodes = new Stack<TreeNode>();
		ArrayList<Integer> currentLevel = new ArrayList<Integer>();
		TreeNode n;
		while (!s.empty()) {
				n = s.pop();
				currentLevel.add(n.val);
				if (level % 2 == 1) {
					if (n.right != null) {
						currentNodes.push(n.right);
					}
					if (n.left != null) {
						currentNodes.push(n.left);
					}
				} else {
					if (n.left != null) {
						currentNodes.push(n.left);
					}
					if (n.right != null) {
						currentNodes.push(n.right);
					}
				}
		}
		l.add(currentLevel);
		return currentNodes;
	}

}
