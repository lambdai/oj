package leetcode;

import java.util.ArrayList;

public class LeetCode025 {
    public ListNode reverseKGroup(ListNode head, int k) {
	if(k == 1 || head == null) { return head; }
	ListNode preRound = null, roundEnd , roundBegin = head, preNode, thisNode, nextNode;
	ListNode result = null, nextRoundBegin;
	while(true) {
	    int count;
	    for(count = 1, roundEnd = roundBegin; count <k && roundEnd != null; count ++) {
		roundEnd = roundEnd.next;
	    }
	    if(roundEnd == null) {
		if(preRound == null) { return roundBegin; }
		preRound.next = roundBegin;
		return result;
	    } else {
		if(preRound != null) {
		    preRound.next = roundEnd;
		} else {
		    result = roundEnd;
		}
		nextRoundBegin = roundEnd.next;
		for(preNode = roundBegin,thisNode = roundBegin.next; preNode != roundEnd; preNode = thisNode, thisNode = nextNode) {
		    nextNode = thisNode.next;
		    thisNode.next = preNode;
		}
		preRound = roundBegin;
	    }
	    roundBegin = nextRoundBegin;

	}
    }

    public static void main(String args[]) {
        LeetCode025 solution = new LeetCode025();
        ListNode[] arr = new ListNode[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ListNode(i);
            if (i - 2 >= 0) {
                arr[i].next = arr[i - 2];
            }
        }
        ArrayList<ListNode> l = new ArrayList<ListNode>();
        l.add(arr[8]);
        l.add(arr[7]);

        solution.reverseKGroup(arr[4], 3).show();

    }
}
