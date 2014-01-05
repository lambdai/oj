package newleetcode;

import dyc.ListNode;

public class Solution {
    
    public void reorderList(ListNode head) {
	if (head == null || head.next == null) { return head; }
	ListNode pMid = findMid(head);
	pMid.dump();
	ListNode pTail = reverse(preMid);
	pTail.dump();
	merge(head, pTail);
	return head;
    }
    
    void findMid(ListNode h) {//, ListNode preMid, listNode preTail) {
	//ListNode p1 = h, p2 = h.next;
	//	ListNode prep1=p1, prep2 = p2;
	while (true) {
	    if(p2 != null) {
		p2 = p2.next;
		if(p2 != null) {
		    p2 = p2.next;
		} else {
		    return p1;
		    //		    prep2 = prep2.next;
		    //		    continue;
		}
	    } else {
		//preMid.next = prep1;
		//preTail.next= prep2;
		return p1;
	    }
	    //	    prep1 = p1;
	    p1 = p1.next;
	}
    }

    ListNode reverse(ListNode preMid) {
	preMid.next = null;
	ListNode current = preMid.next;
	ListNode next = current.next;
	current.next = null;
	ListNode temp = null;
	while (next != null) {
	    temp = next.next;
	    next.next = current;
	    current = next;
	    next = temp;
	}
	return current;
    }

    void merge(ListNode head, ListNode other) {
	ListNode n1 = head.next, n2 = null;

	while (n1 != null) {
	    n2 = other.next;
	    head.next = other;
	    other.next = n1;
	    head = n1;
	    other = n2;
	    n1 = n1.next;
	}
	head.next = other;
    }


}