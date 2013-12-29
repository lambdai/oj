//http://oj.leetcode.com/problems/valid-palindrome/
package newleetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null) {
			return true;
		}
		char str[] = s.toCharArray();
		char charl = 0, charr = 0;
		int il = 0, ir = str.length - 1;
		while (il < ir) {
			while (il < ir) {
				if (str[il] >= 'a' && str[il] <= 'z') {
					charl = str[il];
					break;
				} else if (str[il] >= 'A' && str[il] <= 'Z') {
					charl = (char) (str[il] + ('a' - 'A'));
					break;
				} else if (str[il] >= '0' && str[il] <= '9') {
					charl = str[il];
					break;
				}
				++il;
			}
			charr = charl;
			while (il < ir) {
				if (str[ir] >= 'a' && str[ir] <= 'z') {
					charr = str[ir];
					break;
				} else if (str[ir] >= 'A' && str[ir] <= 'Z') {
					charr = (char) (str[ir] + ('a' - 'A'));
					break;
				} else if (str[ir] >= '0' && str[ir] <= '9') {
					charl = str[ir];
					break;
				}
				--ir;
			}
			if (charl != charr) {
				return false;
			}
			--ir;
			++il;
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println(new ValidPalindrome()
				.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(new ValidPalindrome().isPalindrome("race a car"));
		System.out.println(new ValidPalindrome().isPalindrome("a."));
	}
}
