//http://oj.leetcode.com/problems/scramble-string/
package newleetcode;

public class ScrambleString {
	public boolean isScramble1(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length()) {
			return false;
		}
		boolean isScramble[][][] = new boolean[len + 1][len][len];
		for (int l = 1; l <= len; l++) {
			for (int i1 = 0; i1 <= len - l; i1++) {
				for (int i2 = 0; i2 <= len - l; i2++) {
					if (l == 1) {
						isScramble[l][i1][i2] = s1.charAt(i1) == s2.charAt(i2);
					} else {
						for (int sublen = 1; sublen < l; sublen++) {
							// int olen = l - sublen;
							isScramble[l][i1][i2] = (isScramble[sublen][i1][i2] && isScramble[l
									- sublen][i1 + sublen][i2 + sublen])
									|| (isScramble[sublen][i1][i2 + l - sublen] && isScramble[l
											- sublen][i1 + sublen][i2]);
							if (isScramble[l][i1][i2]) {
								break;
							}
						}
					}
				}
			}
		}
		return isScramble[len][0][0];
	}

	
	boolean sameSet(String s1, String s2) {
        // s1 and s2 already have the same length
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int p = s2.indexOf(c);
            if (p < 0) return false;
            s2 = s2.substring(0, p) + s2.substring(p + 1);
        }
        return (s2.length() == 0);
    }
    
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        
        int i = 0;
        while (i < n && s1.charAt(i) == s2.charAt(i)) i++;
        if (i >= n) return true;
        
        int j = s1.length() - 1;
        while (j >= 0 && s1.charAt(j) == s2.charAt(j)) j--;
        
        if (i > 0 || j < s1.length() - 1) {
            boolean trial = isScramble(s1.substring(i, j + 1), s2.substring(i, j + 1));
            if (trial) return true; // shouldn't break if false
        }
        
        for (int left = 1; left <= n - 1; left++) {
            // AB|CD and BA|DC, forgot this case
            String s1l = s1.substring(0, left), s1r = s1.substring(left);
            String s2l = s2.substring(0, left), s2r = s2.substring(left);
            if (sameSet(s1l, s2l) && sameSet(s1r, s2r)) {
                boolean trial = isScramble(s1l, s2l) && isScramble(s1r, s2r);
                if (trial) return true;
            }
            
            // AB|CDE and DEC|BA, forgot this case
            String s2ll = s2.substring(0, n - left), s2rr = s2.substring(n - left);
            if (sameSet(s1l, s2rr) && sameSet(s1r, s2ll)) {
                boolean trial = isScramble(s1l, s2rr) && isScramble(s1r, s2ll);
                if (trial) return true;
            }
        }
        /*
        int left1 = n - 1;
        while (left1 > 0 && !s1.substring(0, left1).equals(s2.substring(n - left1))) left1--;
        // ABxxxxx and yyyyyAB
        if (left1 > 0) return isScramble(s1.substring(left1), s2.substring(0, n - left1));
        
        int left2 = n - 1;
        while (left2 > 0 && !s2.substring(0, left2).equals(s1.substring(n - left2))) left2--;
        // xxxxxAB and AByyyyy
        if (left2 > 0) return isScramble(s1.substring(0, n - left2), s2.substring(left2));
        */
        return false;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new ScrambleString().isScramble("abc", "bca"));
	}

}
