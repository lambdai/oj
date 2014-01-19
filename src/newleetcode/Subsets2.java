//http://oj.leetcode.com/problems/subsets-ii/
package newleetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return ret;
		}
		Arrays.sort(num);
		int len = num.length;
		ArrayList<Integer> soFar = new ArrayList<Integer>(len);
		genSet(ret, num, 0, len - 1, soFar);
		return ret;
	}

	private void genSet(ArrayList<ArrayList<Integer>> ret, int[] num, int il,
			int ir, ArrayList<Integer> current) {
		if (il > ir) {
			ret.add((ArrayList<Integer>) current.clone());
			return;
		}
		int cVal = num[il];
		int end = il;
		while (end <= ir && cVal == num[end]) {
			++end;
		}
		ArrayList<Integer> newlist = (ArrayList<Integer>) current.clone();
		genSet(ret, num, end, ir, newlist);

		for (int i = il; i < end; i++) {
			newlist.add(cVal);
			genSet(ret, num, end, ir, newlist);
		}
		return;

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(ArrayList<Integer> solution : new Subsets2().subsetsWithDup(new int[]{1,2,2}) ){
			StringBuffer sb = new StringBuffer();
			sb.append('[');
			for(Integer i : solution) {
				sb.append(i).append(',');
			}
			if(sb.length() == 1) {
				sb.append(']');
			} else {
				sb.setCharAt(sb.length()-1, ']');
			}
			System.out.println(sb.toString());
		}
	}
}
