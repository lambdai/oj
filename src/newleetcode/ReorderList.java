package newleetcode;

import dyc.ListNode;

public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode pMid = findMid(head);
		//pMid.dump();
		ListNode pTail = reverse(pMid);
		//pTail.dumpList();
		merge(head, pTail);
		//head.dumpList();
		return;
	}

	ListNode findMid(ListNode h) {// , ListNode preMid, listNode preTail) {
		ListNode p1 = h, p2 = p1;
		ListNode ret = p1;
		while (true) {
			if (p2 != null) {
				p2 = p2.next;
				if (p2 != null) {
					p2 = p2.next;
				} else {
					return ret;
					// prep2 = prep2.next;
					// continue;
				}
			} else {
				// preMid.next = prep1;
				// preTail.next= prep2;
				return ret;
			}
			// prep1 = p1;
			ret = p1;
			p1 = p1.next;
		}
	}

	ListNode reverse(ListNode preMid) {
		//preMid.next = null;
		
		ListNode current = preMid.next;
		preMid.next = null;
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
		ListNode n1 = head, n2 = other;
		ListNode next1 = null;
		next1 = n1.next;
		n1.next = n2;
		n1 = next1;
		while (n1 != null) {
			
			next1 = n2.next;
			n2.next = n1;
			n2 = next1;
			
			next1 = n1.next;
			n1.next = n2;
			n1 = next1;
		}
	}
	
	public static void main(String args[]) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2; n2.next = n3; n3.next = n4;
		new ReorderList().reorderList(n1);
		n1.dumpList();
		return;
	}

}