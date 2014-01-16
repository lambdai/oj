//http://oj.leetcode.com/problems/powx-n/
package newleetcode;

public class Pow {
	public double pow(double x, int n) {
		if (n > 0) {
			int half = n / 2;
			double y = pow(x, half);
			y *= y;
			return (n & 1) == 1 ? x * y : y;
		} else if (n == 0) {
			return 1.0;
		} else if (n > Integer.MIN_VALUE) {
			return 1 / pow(x, -n);
		} else {
			double y = pow(x, n / 2);
			return 1 / (y * y);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
