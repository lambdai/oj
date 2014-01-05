//http://oj.leetcode.com/problems/3sum/
package newleetcode;

import java.util.ArrayList;

public class TriSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 3) {
			return arr;
		}
		heapSort(num);
		//quicksortRecusion(num, 0, num.length-1);
		for (int i = 2; i < num.length; ++i) {
			if(i==num.length-1 ||  num[i] != num[i+1]) {
				findMatch(num, i, arr);
			}
		}
		return arr;
	}

	void findMatch(int[] num, int idest, ArrayList<ArrayList<Integer>> res) {
		int dest = -num[idest];
		int ileft = 0;
		int iright = idest - 1;
		while (ileft < iright) {
			if (ileft != 0 && num[ileft - 1] == num[ileft]) {
				++ileft;
				continue;
			}
			if (iright != idest - 1 && num[iright + 1] == num[iright]) {
				--iright;
				continue;
			}
			int sum = num[ileft] + num[iright];
			if (sum == dest) {
				ArrayList<Integer> solution = new ArrayList<Integer>();
				solution.add(num[ileft]);
				solution.add(num[iright]);
				solution.add(num[idest]);				
				//System.out.println(String.format("%d %d %d", num[ileft], num[iright], num[idest]));
				res.add(solution);
				++ileft;
				--iright;
			} else if (sum < dest) {
				++ileft;
			} else {
				--iright;
			}
		}
	}

	public static void heapSort(int[] num) {
		int len = num.length;
		bigHeapify(num,len);
		for(int i = len-1; i >0; --i) {
			int temp = num[0];
			num[0] = num[i];
			num[i] = temp;
			downHeap(num, 0, i);
		}
	}
	
	public static void bigHeapify(int [] num, int len){
		for (int i = (len - 1) / 2; i >= 0; --i) {
			downHeap(num, i, len);
		}
	}

	public static void downHeap(int[] num, int i, int len) {
		int ileft = 2 * i + 1;
		int iright = ileft + 1;
		int imax = -1;
		if (ileft >= len) {
			return;
		}
		if (iright >= len) {
			imax = ileft;
		} else {
			imax = num[ileft] < num[iright] ? iright : ileft;
		}
		if (num[imax] > num[i]) {
			int temp = num[i];
			num[i] = num[imax];
			num[imax] = temp;
			downHeap(num, imax, len);
		}
	}
	public static void quicksortRecusion(int[] num, int l, int r) {
		if (l >= r) {
			return;
		}
		int pivot = num[l];
		int iless = l, icurrent;
		for (icurrent = l + 1; icurrent <= r; ++icurrent) {
			if (num[icurrent] < pivot) {
				int temp = num[iless + 1];
				num[iless + 1] = num[icurrent];
				num[icurrent] = temp;
				++iless;
			}
		}
		num[l] = num[iless];
		num[iless] = pivot;
		quicksortRecusion(num, l, iless - 1);
		quicksortRecusion(num, iless + 1, r);
	}
	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> l = new TriSum().threeSum(new int[]{-1,0,1});
		//ArrayList<ArrayList<Integer>> l = new TriSum().threeSum(new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6});
	}
}
