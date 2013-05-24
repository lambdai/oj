package leetcode;

public class LeetCode019 {
    public ListNode removeNthFromEnd(ListNode head, int n){
	
	ListNode iNode = head;
	ListNode forward = head;
	while(n!=0){
	    forward = forward.next;
	    n--;
	}
	while(forward != null) {
	    forward = forward.next;
	    if(forward == null) {
		iNode.next = iNode.next.next;
		break;
	    } else {
		iNode = iNode.next;
	    }
	}
	
	return head;
    }
}