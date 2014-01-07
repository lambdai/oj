//http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
package newleetcode;

import dyc.ListNode;
import dyc.TreeNode;

public class ConvertSortedList2BinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
    	ListNode pNode = head;
    	int i;
    	for(i = 0; pNode != null; ) {
    		i++; pNode = pNode.next; 
    	}
    	pNode = new ListNode(0);
    	pNode.next = head;
    	TreeNode tNode = genTree(pNode, 1, i);
    	return tNode;
        
    }
    
    
    TreeNode genTree(ListNode lNode, int start, int end) {
    	if(start > end) {
    		return null;
    	}
    	int mid = (start + end) /2;
    	TreeNode left = genTree(lNode, start, mid-1);
    	TreeNode root = new TreeNode(lNode.next.val);
    	lNode.next = lNode.next.next;
    	root.left = left;
    	root.right = genTree(lNode, mid+1, end);
    	return root;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2; l2.next = l3;
		TreeNode root = new ConvertSortedList2BinarySearchTree().sortedListToBST(l1);
		System.out.println(root);
		
		return;
	}

}
