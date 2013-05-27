package leetcode;

import java.util.ArrayList;

public class LeetCode024 {
    public ListNode swapPairs(ListNode head) {
	if(head == null) { return null; }
	int count = 0;
	ListNode sentinel = new ListNode(0);
	ListNode thisNode = head;
	ListNode preNode, preRound = sentinel, thisEnd, nextNode;
	while(true) {
	    count = 0;
	    preNode = null;
	    if(thisNode == null) {
		break;
	    }
	    thisEnd = thisNode;
	    while(count < 2 && thisNode!= null) {
		nextNode = thisNode.next;
		thisNode.next = preNode;
		preNode = thisNode;
		thisNode = nextNode;
		count ++;
	    }
	    preRound.next = preNode;
	    thisEnd.next = null;
	    preRound = thisEnd;
	    if(count != 2) {
		break;
	    }
	}
	return sentinel.next;
    }
    
    public static void main(String args[]){
        LeetCode024 solution = new LeetCode024();
        ListNode[] arr = new ListNode[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new ListNode(i);
            if(i-2 >=0){
                arr[i].next = arr[i-2];
            }
        }
        ArrayList<ListNode> l = new ArrayList<ListNode>();
        l.add(arr[8]);
        l.add(arr[7]);
        
        solution.swapPairs(arr[6]).show();
        
    }
}