package dyc;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public void dump() {
		System.out.println("" + val + "\t, next.val = " + next.val);
	}

	public static ListNode fromArray(int[] arr) {
		return fromArray(arr, 0, arr.length - 1);
	}

	public static ListNode fromArray(int[] arr, int start, int end) {
		return null;
	}
}