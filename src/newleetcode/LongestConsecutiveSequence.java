//http://oj.leetcode.com/problems/longest-consecutive-sequence/
package newleetcode;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		HashMap<Integer, Integer> tree = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> sizes = new HashMap<Integer, Integer>();
		for (int a = 0; a < num.length; a++) {
			int i = num[a];
			if (!tree.containsKey(i)) {

				tree.put(i, i);
				if (tree.containsKey(i + 1)) {
					sizes.put(i, sizes.get(i + 1) + 1);
					tree.put(i + 1, i);
					sizes.remove(i + 1);
				} else {
					sizes.put(i, 1);
				}
				if (tree.containsKey(i - 1)) {
					int j = i - 1;
					int k;
					// find root;
					while ((k = tree.get(j)) != j) {
						j = k;
					}
					tree.put(i, k);
					sizes.put(k, sizes.get(k) + sizes.get(i));
					sizes.remove(i);
				}
			}
		}
		int max = 0;
		for (int v : sizes.values()) {
			if (max < v) {
				max = v;
			}
		}
		/*
		 * for(Entry<Integer, Integer> entry : sizes.entrySet()) {
		 * //System.out.println(entry.getKey() + ":" + entry.getValue()); if
		 * (entry.getValue() > max) { max = entry.getValue(); } }
		 */
		return max;

	}

	public static void main(String[] args) {
		System.out.println(new LongestConsecutiveSequence()
				.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
		System.out.println("pause");

	}
}