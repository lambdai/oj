package leetcode;

public class LeetCode029 {
    public int divide(int dividend, int divisor) {
        if(divisor == Integer.MIN_VALUE) { return dividend == Integer.MIN_VALUE ? -1 : 0; }
	boolean isPositive = ( (dividend > 0) && ( divisor > 0) ) ||( (dividend < 0) && (divisor < 0) );
	dividend = dividend < 0 ? dividend : -dividend;
	divisor = divisor < 0 ? divisor : -divisor;
	int maxShift = 32;
	int[] mutiples = new int[maxShift];
	int[] coeffs = new int[maxShift];
	int i,j = 0,coeff;
	for(i = 0, j= divisor, coeff = 1; j<0 && j >= dividend; i++,j=j+j, coeff= coeff +coeff) {
	    mutiples[i] = j;
	    coeffs[i] = coeff;
	}
	int result = 0;
	for(int k = i-1; k >=0; k--){
	    if(dividend <= mutiples[k]) {
		result -= coeffs[k];
		dividend -= mutiples[k];
	    }
	}
	return isPositive? -result : result;
    }

    public static void main(String args[]) {
	LeetCode029 solution = new LeetCode029();
	System.out.println(solution.divide(100, 99));
	System.out.println(solution.divide(100, 50));
	System.out.println(solution.divide(-2147483648, 1));
    }
}