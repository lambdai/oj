//http://oj.leetcode.com/problems/longest-palindromic-substring/
package newleetcode;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null) {
			return null;
		}
		if (s.length() == 0) {
			return "";
		}
		int rmost = 0, rmid = 0;
		int maxlen = 0, imaxstart = 0;
		byte arr[] = new byte[2 * s.length() + 1];
		byte sbyte[] = s.getBytes();

		for (int i = 0; i < sbyte.length; ++i) {
			arr[2 * i + 1] = sbyte[i];
		}

		int len = 2 * sbyte.length + 1;
		int imid = 1;
		int radius[] = new int[len];
		int symCenter;
		int myradius;
		for (imid = 0; imid < len; ++imid) {
			if (rmost >= imid) {
				symCenter = 2 * rmid - imid;
				myradius = radius[symCenter];
			} else {
				myradius = 1;
			}
			while (imid + myradius < len && imid - myradius >= 0
					&& arr[imid + myradius] == arr[imid - myradius]) {
				myradius++;
			}
			myradius--;
			radius[imid] = myradius;
			// xSxSx
			// TxSxT
			int originalPlen = imid % 2 == 0 ? (myradius + 1) / 2 * 2
					: myradius / 2 * 2 + 1;
			int originalPstart = imid % 2 == 0 ? (imid + 1) / 2 - originalPlen
					/ 2 : (imid / 2) - originalPlen / 2;
			if (originalPlen > maxlen) {
				maxlen = originalPlen;
				imaxstart = originalPstart;
			}
			if (imid + myradius >= len-2) {
				break;
			}
		}
		return s.substring(imaxstart, imaxstart + maxlen);
	}
	
	public static void main(String args[]) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("caba"));
	}
}
