//http://oj.leetcode.com/problems/3sum-closest/
package newleetcode;


public class TriSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num.length <= 3) {
			int sum = 0;
			for(int i=0; i< num.length; ++i) {
				sum += num[i];
			}
			return sum;
		}
		//Tools.quicksort(num);
		quicksortRecusion(num, 0, num.length-1);
		int closest = -1;
		int closestdest = 0;
		int dest;
		int cur;
		int diff;
		for (int i = 2; i < num.length; ++i) {
			dest = target - num[i];
			int l = 0, r = i-1;
			while(l < r) {
				cur = num[l] + num[r];
				if (cur > dest) {
					diff = cur - dest;
				} else {
					diff = dest - cur;
				}
				if (diff < closest || closest < 0) {
					closest = diff;
					closestdest = cur + num[i];
					if (closest == 0) {
						return target;
					}
				}
				if (cur < dest) {
					++l;
				} else {
					--r;
				}
			}
		}
		return closestdest;
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



}