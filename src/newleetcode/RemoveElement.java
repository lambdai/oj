//http://oj.leetcode.com/problems/remove-element/
package newleetcode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int i = 0, j = A.length - 1;
		while (i < j) {
			while (A[j] == elem && i < j) {
				j--;
			}
			if (i == j) {
				break;
			}
			while (A[i] != elem && i < j) {
				i++;
			}
			if (i == j) {
				break;
			}
			A[i] = A[j];
			j--;
			// i++;
		}
		if (A[i] != elem) {
			return i + 1;
		} else {
			return i;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
