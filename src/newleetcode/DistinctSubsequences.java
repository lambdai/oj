//http://oj.leetcode.com/problems/distinct-subsequences/
package newleetcode;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int lenS = S.length(), lenT = T.length();
		int[] matchespre = new int[lenS + 1];
		for (int i = 0; i <= lenS; ++i) {
			matchespre[i] = 1;
		}

		int[] matchescur = new int[lenS + 1];
		int[] temp = null;
		for (int i = 0; i < lenT; ++i) {
			matchescur[i] = 0;
			for (int j = i + 1; j <= lenS; ++j) {
				matchescur[j] = S.charAt(j - 1) != T.charAt(i) ? matchescur[j - 1]
						: (matchescur[j - 1] + matchespre[j - 1]);
			}
			temp = matchespre;
			matchespre = matchescur;
			matchescur = temp;
		}

		return matchespre[lenS];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    System.out.println(new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));

	}

}
