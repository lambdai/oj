package newleetcode;

import dyc.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
	if (p == null) {
	    if (q != null) {
		return false;
	    }
	    return true;
	}
	if (q == null) {
	    return false;
	}
	if (p.val != q.val) {
	    return false;
	}
	if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
	    return true;
	}
	return false;
    }
}
