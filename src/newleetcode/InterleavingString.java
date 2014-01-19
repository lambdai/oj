//http://oj.leetcode.com/problems/interleaving-string/
package newleetcode;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l1 + l2 != l3) {
			return false;
		}
		boolean match[][] = new boolean[l1 + 1][l2 + 1];
		match[0][0] = true;
		for (int i = 1; i <= l1; i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
				match[i][0] = true;
			} else {
				break;
			}
		}
		for (int j = 1; j <= l2; j++) {
			if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
				match[0][j] = true;
			} else {
				break;
			}
		}
		for (int i = 2; i <= l3; i++) {
			int match1_start = i <= l2 ? 1 : i - l2;
			// int match1_end = i <= l1 ? l1 : i;
			for (int c1 = match1_start; c1 <= l1; ++c1) {
				int c2 = i - c1;
				if (c2 < 1) {
					break;
				}
				match[c1][c2] = (match[c1][c2 - 1] && s3.charAt(i - 1) == s2
						.charAt(c2 - 1))
						|| (match[c1 - 1][c2] && s3.charAt(i - 1) == s1
								.charAt(c1 - 1));
			}
		}
		return match[l1][l2];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new InterleavingString()
				.isInterleave("a", "b", "ba"));
		System.out.println(new InterleavingString().isInterleave("aabcc",
				"dbbca", "aadbbcbcac"));
		System.out.println(new InterleavingString().isInterleave("aabcc",
				"dbbca", "aadbbbaccc"));
	}

}
