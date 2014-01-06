//http://oj.leetcode.com/problems/pascals-triangle-ii/
package newleetcode;

import java.util.ArrayList;

public class PascalTriangle2 {
	public ArrayList<Integer> getRow(int rowIndex) {
		if(rowIndex < 0) { return null;}
		int arr[] = new int[rowIndex + 1];
		arr[0] = 1;
		int prevElement, currentElement;
		for (int l = 1; l <= rowIndex; ++l) {
			prevElement = arr[l-1];
			for (int i = 1; i < l; i++) {				
				currentElement = arr[i];
				arr[i] = prevElement + arr[i];
				prevElement = currentElement;
			}
			arr[l] = 1;
		}
		ArrayList<Integer> ret = new ArrayList<Integer>(rowIndex);
		for(int n:arr) {
			ret.add(n);
		}
		return ret;
		
	}
	public static void main(String args[]) {
		ArrayList<Integer> arr;
		arr = new PascalTriangle2().getRow(0);
		arr = new PascalTriangle2().getRow(1);
		arr = new PascalTriangle2().getRow(3);
		return;
	}
}
