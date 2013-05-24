package leetcode;

import java.util.ArrayList;

public class LeetCode022 {

    public ArrayList<String> generateParenthesis(int n) {
        // int iters[] = new int[n+1];
        ArrayList<String> result = new ArrayList<String>(n * n);
        int pos[] = new int[n + 1];
        int full[] = new int[n + 1];
        for (int z = 0; z < n; z++) {
            pos[z] = z;
        }
        for (int z = 0; z < n; z++) {
            full[z] = z + 1;
        }
        full[n - 1] = 2 * n - 1;
        char[] buffer = new char[2 * n];
        int num = 0;
        while (true) {

            // Add to collection
            for (int i = 0; i < 2 * n; i++) {
                buffer[i] = ')';
            }
            for (int i = 0; i < n; i++) {
                buffer[pos[i]] = '(';
            }

            result.add(new String(buffer));

            // num++;
            // System.out.printf("%d\t%s\n", num, new String(buffer));
            boolean shouldBreak = false;
            for (int i = 0; i < n; i++) {

                pos[i] += 1;
                // int full = (pos[i+1] > 2*i+1) ? 2*i+1: pos[i+1];
                if (pos[i] == full[i]) {
                    // carrier++;
                    pos[i] = i;
                    if (i > 0) {
                        full[i - 1] = (pos[i] > 2 * i - 1) ? 2 * i - 1 : pos[i];
                    }
                    // continue;
                } else {
                    // pos[i]++;
                    full[i - 1] = (pos[i] > 2 * i - 1) ? 2 * i - 1 : pos[i];
                    // continue nextString;
                    shouldBreak = true;
                    break;
                }

            }
            if (shouldBreak) {
                continue;
            }
            // System.out.println(num);
            return result;
        }

    }

    /*
     * ArrayList<String> result; int num =0; void go(int n, int left, int right,
     * String prefix) { if (n == 0) { // no more pairs, just finish the unquoted
     * "(" while (left > right) { prefix += ")"; right++; } result.add(prefix);
     * num++; return; } // add one more "(" go(n - 1, left + 1, right, prefix +
     * "("); // finish some "(" if (left > right) go(n, left, right + 1, prefix
     * + ")"); } public ArrayList<String> generateParenthesis(int n) { result =
     * new ArrayList<String>(); num = 0; if (n == 0) return result; go(n, 0, 0,
     * ""); System.out.println(num); return result; }
     */
    public static void main(String args[]) {
        LeetCode022 solution = new LeetCode022();
        // for(int i =1; i< 10; i++) {
        // System.out.printf("%d\t",i);
        solution.generateParenthesis(4);
        // }
    }
}
