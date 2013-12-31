//http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
package newleetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> is = new Stack<Integer>();
		for (String token : tokens) {
			if (token.equals("+")) {
				int i1 = is.pop();
				int i2 = is.pop();
				is.push(i2 + i1);
			} else if (token.equals("-")) {
				int i1 = is.pop();
				int i2 = is.pop();
				is.push(i2 - i1);
			} else if (token.equals("*")) {
				int i1 = is.pop();
				int i2 = is.pop();
				is.push(i1 * i2);
			} else if (token.equals("/")) {
				int i1 = is.pop();
				int i2 = is.pop();
				is.push(i2 / i1);
			} else {
				is.push(Integer.valueOf(token));
			}
		}
		return is.pop();
	}
	
	public static void main(String args[]) {
		System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[] {
				"2", "1", "+", "3", "*"
				}));
		
	}
}
