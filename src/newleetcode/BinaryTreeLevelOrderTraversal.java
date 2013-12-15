package newleetcode;

import java.util.ArrayList;

import dyc.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	levelOrder(root, list, 1);
    	return list;
    }
    
    public void levelOrder(TreeNode n, ArrayList<ArrayList<Integer>> l, int level) {
    	if(n == null) { return;}
    	ArrayList<Integer> clist;
    	if (l.size() < level) {
    		ArrayList<Integer> l2 = new ArrayList<Integer>();
    		l.add(l2);
    		clist = l2;
    	} else {
    		clist = l.get(level-1);
    	}
    	clist.add(n.val);
    	levelOrder(n.left, l, level+1);
    	levelOrder(n.right,l, level+1);
    }
    
    public static void main(String[] args){
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(2);
    	TreeNode n3 = new TreeNode(3);
    	n1.left = n2;
    	n1.right = n3;
    	new BinaryTreeLevelOrderTraversal().levelOrder(n1);
    }

}
