package dyc;
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
	val = x;
	next = null;
    }
    public dump() {
	System.out.println("" + val + "\t, next.val = " + next.val);
    }

    public static ListNode fromArray(int[] arr) {
	
    }
    public static ListNode fromArray(int[] arr, int start, int end) {
    }
}