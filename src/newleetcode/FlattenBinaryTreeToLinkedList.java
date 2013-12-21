//http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
package newleetcode;

import dyc.TreeNode;
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
    	if (root == null) { return;}
	flat(root);
    }
    public TreeNode flat(TreeNode n) {
	if (n.left == null) { 
	    if (n.right != null) {
		return flat(n.right); 
	    }
	    return n;
	}
	TreeNode res = flat(n.left);
	TreeNode rn = n.right;
	n.right = n.left;
	n.left = null;
	
	if (rn == null) { return res; }
	res.right = rn;
	return flat(rn);

    }
    
    public static void main(String[] args){
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(2);
    	TreeNode n3 = new TreeNode(3);
    	n1.left = n2;
    	n1.right = n3;
    	new FlattenBinaryTreeToLinkedList().flatten(n1);
    	TreeNode n = n1;
    	while(n != null) {
    		System.out.println(n.val);
    		n=n.right;
    	}
    }
}