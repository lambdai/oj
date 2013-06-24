package leetcode;


public class LeetCode002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	int carrier = 0;
	ListNode result = null;
	ListNode leftNodes = null;
	ListNode preNode = null;
	while(l1 != null || l2 != null){
	    if (l1 != null && l2 != null){
		
		ListNode newNode = new ListNode(l1.val + l2.val + carrier);
		if(result == null) {
		    result = newNode;
		}

		carrier = 0;
		while(newNode.val >9){
		    carrier++;
		    newNode.val -= 10;
		}
		l1 = l1.next;
		l2 = l2.next;
		if(preNode != null) {
		    preNode.next = newNode;
		}
		preNode = newNode;
		continue;
	    }
	    if(l1 == null) {
		leftNodes = l2;
	    } else {
		leftNodes = l1;
	    }
	    break;
	}
	while(leftNodes != null) {
	    ListNode n = new ListNode(leftNodes.val+carrier);
	    carrier = 0;
	    while(n.val >9){
		carrier++;
		n.val -= 10;
	    }
	    preNode.next = n;
	    preNode = n;
	    leftNodes = leftNodes.next;
	}
	if(carrier > 0){
	    ListNode n = new ListNode(carrier);
	    preNode.next = n;
	}
	return result;
    }
    public static void main(String args[]){
        ListNode x = ListNode.genFromInt(1010);
        ListNode y = ListNode.genFromInt(9999);
        new LeetCode002().addTwoNumbers(x, y).print();
    }

}