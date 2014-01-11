//http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
package newleetcode;

import java.util.ArrayList;
import java.util.Stack;

import dyc.TreeNode;

public class PreorderTravel {
	private final int DOLEFT = 1, DORIGHT = 2, DONE = 3;
	ArrayList<Integer> ret;

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ret = new ArrayList<Integer>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> opstack = new Stack<Integer>();
		// ret.add(root.val);
		int op;
		stack.push(root);
		opstack.push(DOLEFT);
		TreeNode current = root;
		//boolean isPush = true;
		while (!stack.empty()) {
			current = stack.peek();
			op = opstack.pop();
			if (op == DOLEFT) {
				visit(current);
				opstack.push(DORIGHT);
				if (current.left != null) {
					stack.push(current.left);
					opstack.push(DOLEFT);
				}
			} else if (op == DORIGHT) {
				opstack.push(DONE);
				if (current.right != null) {
					stack.push(current.right);
					opstack.push(DOLEFT);
				}
			} else {
				stack.pop();
			}
		}
		return ret;
	}

	private void visit(TreeNode node) {
		ret.add(node.val);
		System.out.println(node.val);
	}
	
	public static void main(String args[]) {
		TreeNode root = TreeNode.genTreeFromString("{1,2}");
		new PreorderTravel().preorderTraversal(root);
	}
}
