//http://oj.leetcode.com/problems/unique-binary-search-trees-ii/
package newleetcode;

import dyc.TreeNode;
import java.util.ArrayList;

public class UniqueBinarySearchTree2 {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    public static ArrayList<TreeNode> generateTrees(int s, int e) {
    	if (s > e) {
    		ArrayList<TreeNode> l = new ArrayList<TreeNode>();
    		l.add(null);
    		return l;
    	}
    	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    	//ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    	for(int i = s; i <= e; i++) {
    		ArrayList<TreeNode> llist = generateTrees(s, i-1);
    		ArrayList<TreeNode> rlist = generateTrees(i+1, e);
    		
    		
    		for (TreeNode ln: llist) {
    			
    			for(TreeNode rn: rlist) {
    				TreeNode r = new TreeNode(i);
        			r.left = ln;
    				r.right = rn;
    				result.add(r);
    			}
    			
    		}
    	}
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (TreeNode n : new UniqueBinarySearchTree2().generateTrees(3)) {
			n.dump();
		}
	}

}
