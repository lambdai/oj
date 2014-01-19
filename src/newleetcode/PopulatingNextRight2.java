//http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
package newleetcode;

import dyc.TreeLinkNode;

public class PopulatingNextRight2 {
	public void connect(TreeLinkNode root) {
		connect(root, null);
	}

	private void connect(TreeLinkNode node, TreeLinkNode parent) {
		if (node == null) {
			return;
		}
		if (parent == null) {
			node.next = null;
		} else {
			if (node == parent.right) {
				node.next = findLeftmost(parent.next);
			} else {
				node.next = parent.right != null ? parent.right
						: findLeftmost(parent.next);
			}
		}
		connect(node.right, node);
		connect(node.left, node);
	}

	private TreeLinkNode findLeftmost(TreeLinkNode p) {
		if (p == null) {
			return null;
		}
		if (p.left != null) {
			return p.left;
		}
		if (p.right != null) {
			return p.right;
		}
		return findLeftmost(p.next);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
