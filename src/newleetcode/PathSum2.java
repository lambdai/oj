package newleetcode;

import java.util.ArrayList;
import java.util.Stack;

import dyc.TreeNode;

public class PathSum2 {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Stack<Integer> upperPath = new Stack<Integer>();
		pathSum(root, sum, result, upperPath);
		return result;
	}

	void pathSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result,
			Stack<Integer> upperPath) {
		if (node == null) {
			return;
		}
		upperPath.push(node.val);
		int sumLeft = sum - node.val;
		if (sumLeft == 0 && node.left == null && node.right == null) {
			ArrayList<Integer> solution = new ArrayList<Integer>();
			for (int i : upperPath) {
				solution.add(i);
			}
			result.add(solution);
		}
		pathSum(node.left, sumLeft, result, upperPath);
		pathSum(node.right, sumLeft, result, upperPath);
		upperPath.pop();
	}
	
	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		for(int i: stack) {
			System.out.println(i);
		}
	}
}
