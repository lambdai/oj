//http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
package newleetcode;

public class SearchRotatedSortedArray {

	public int search(int[] A, int target) {
		if (A == null) { return -1; }
		return searchDual(A, target, 0, A.length-1);
	}

	private int searchDual(int[] a, int target, int il, int ir) {
		if (il > ir) { return -1;}
		int imid = (il + ir) /2;
		if (target == a[imid]) { return imid; }
		if(il == imid) {return a[ir] == target ? ir: -1;}
		if (target < a[imid]) {
			if (a[il] < a[imid]) {
				return a[il] <= target ? search(a, target, il, imid-1) : searchDual(a, target, imid + 1, ir);
			} else {
				return searchDual(a, target, il, imid-1);
			}
		} else {
			if (a[ir] > a[imid]) {
				return a[ir] >= target ? search(a, target, imid+1, ir) : searchDual(a, target, il, imid-1);
			} else {
				return searchDual(a, target, imid+1, ir);
			}
		}
	}

	private int search(int[] a, int target, int il, int ir) {
		if (il > ir) {return -1;}
		int imid = (il +ir)/2;
		if(target == a[imid]) { return imid; }
		if (target < a[imid]) {
			return search(a, target , il, imid-1);
		} else {
			return search(a, target, imid +1, ir);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
