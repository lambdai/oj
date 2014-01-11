//http://oj.leetcode.com/problems/copy-list-with-random-pointer/
package newleetcode;

import dyc.RandomListNode;

public class CopyListRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode n = head;
		if (n == null) {
			return null;
		}
		while (n != null) {
			RandomListNode copy = new RandomListNode(n.label);
			copy.next = n.next;
			n.next = copy;
			n = copy.next;
		}

		n = head;
		RandomListNode chead = n.next;
		RandomListNode copied = null;
		while (n != null) {
			copied = n.next;
			if (n.random != null) {
				copied.random = n.random.next;
			} else {
				copied.random = null;
			}
			n = copied.next;
		}
		n = head;
		copied = head;
		while (n != null) {
			copied.next = n.next;
			copied = n.next;
			n.next = copied.next;
			n = copied.next;
		}
		return chead;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
