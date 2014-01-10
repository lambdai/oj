//http://oj.leetcode.com/problems/palindrome-partitioning-ii/
package newleetcode;

public class PalindromePartitioning2 {
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		boolean isPalindrome[][] = new boolean[len][len];
		for (int step = 0; step < len; ++step) {
			for (int i = 0; i < len - step; ++i) {
				if (step <= 1) {
					isPalindrome[i][i + step] = step == 0 ? true
							: s.charAt(i) == s.charAt(i + step);
				} else {
					isPalindrome[i][i + step] = isPalindrome[i + 1][i + step
							- 1]
							&& s.charAt(i) == s.charAt(i + step);
				}
			}
		}
		int minCut = len;
		int minCuts[] = new int[len];
		for (int r = 0; r < len; ++r) {
			if (isPalindrome[0][r]) {
				minCuts[r] = 1;
				continue;
			}
			int min = len;
			for (int l = 1; l <= r; ++l) {
				if (isPalindrome[l][r]) {
					int thismin = minCuts[l - 1] + 1;
					if (thismin < min) {
						min = thismin;
					}
				}
			}
			minCuts[r] = min;
		}
		return minCuts[len - 1] - 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PalindromePartitioning2().minCut("aabaa"));
		System.out.println(new PalindromePartitioning2().minCut("ab"));
	}

}
