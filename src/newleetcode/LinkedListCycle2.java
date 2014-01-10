//http://oj.leetcode.com/problems/linked-list-cycle-ii/
package newleetcode;

import dyc.ListNode;

public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode i1 = head, i2 = head;
		i2 = i2.next;
		if (i2 != null) {
			i2 = i2.next;
		} else {
			return null;
		}
		i1 = i1.next;
		// int steps = 1;
		while (i1 != i2) {
			if (i2 != null) {
				i2 = i2.next;
			} else {
				return null;
			}
			if (i2 != null) {
				i2 = i2.next;
			} else {
				return null;
			}

			i1 = i1.next;
			// steps ++;
		}
		ListNode i3 = head;
		while (i3 != i1) {
			i3 = i3.next;
			i1 = i1.next;
		}
		return i1;
	}

}
