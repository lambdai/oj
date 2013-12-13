package dyc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	static final String SHARP = "#";
	
	public void dump() {
		ArrayList<String> arr = new ArrayList<String>();
		List<TreeNode> q = new LinkedList<TreeNode>();
		q.add(this);
		arr.add(String.valueOf(val));
		while(!q.isEmpty()) {
			TreeNode n = q.remove(0);
			n.dump(arr, q);
		}
		System.out.print("{");
		for (String s : arr) {
			System.out.print(s + ",");
		}
		System.out.println("}");
	}
	public void dump(List<String> arr, List<TreeNode> q) {
		if (left == null && right == null) { return; }
		if(left != null) {
			arr.add(String.valueOf(left.val));
			q.add(left);
		} else {
			arr.add(SHARP);
		}
		if(right != null) {
			arr.add(String.valueOf(right.val));
			q.add(right);
		} else {
			arr.add(SHARP);
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode x1 = new TreeNode(1);
		TreeNode x2 = new TreeNode(2);
		TreeNode x3 = new TreeNode(3);
		x1.right = x2;
		x2.right = x3;
		x1.dump();
	}
}
