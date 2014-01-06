//http://oj.leetcode.com/problems/triangle/
package newleetcode;

import java.util.ArrayList;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int len = triangle.size();
		int sums[] = new int[len+1];
		int idxl = 0;
		int min = 0;
		for (ArrayList<Integer> line : triangle) {
			boolean leftmost = true;
			int i = len - idxl - 1;
			for (int num : line) {
				
				if (leftmost) {
					// success even if the first line, because we set the sums[len] = 0 due to array initialization in java
					sums[i] = sums[i+1] + num;
					min = sums[i];
					leftmost = false;
				} else {
					if(i+1 < len) {
					sums[i] = sums[i] < sums[i + 1] ? sums[i] + num
							: sums[i + 1] + num;
					} else {
						sums[i] = sums[i] + num;
					}
					min = sums[i] < min ? sums[i] : min;
				}
				++i;
			}
			++idxl;
		}
		return min;
	}
	
	public static void main(String args[]) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		ArrayList<Integer> arr4 = new ArrayList<Integer>();
		arr1.add(2);
		arr2.add(3); arr2.add(4);
		arr3.add(6); arr3.add(5); arr3.add(7);
		arr4.add(4); arr4.add(1); arr4.add(8);arr4.add(3);
		ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
		tri.add(arr1);tri.add(arr2);tri.add(arr3);tri.add(arr4);
		System.out.println(new Triangle().minimumTotal(tri));
		
		
	}
}
