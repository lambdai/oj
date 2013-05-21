package leetcode;

public class LeetCode006 {
    public String convert(String s, int nRows) {
        int i;
        int d = nRows > 1 ? 2 * (nRows - 1) : 1;

        StringBuilder sb = new StringBuilder(s.length());
        char[] bytes = s.toCharArray();

        for (i = 0; i < bytes.length; i += d) {
            sb.append(bytes[i]);
        }

        if (nRows > 2) {
            int securityLen = bytes.length / d * d;

            for (int j = 1; j < nRows - 1; j++) {
                for (i = 0; i < securityLen; i += d) {
                    sb.append(bytes[i + j]);
                    sb.append(bytes[i + d - j]);
                }
                if (i + j < bytes.length) {
                    sb.append(bytes[i + j]);
                }
                if (i + d - j < bytes.length) {
                    sb.append(bytes[i + d - j]);
                }
            }
        }
        if (nRows > 1) {
            for (i = nRows - 1; i < bytes.length; i += d) {
                sb.append(bytes[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
	LeetCode006 solution = new LeetCode006();
	String s = solution.convert("", 1);
	System.out.println(s);
	System.out.println("END");
    }
}
