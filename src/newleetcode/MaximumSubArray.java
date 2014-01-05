//http://oj.leetcode.com/problems/maximum-subarray/
package newleetcode;

public class MaximumSubArray {
    public int maxSubArray(int[] A) {
        int res=0;
        int prev=0;;
        for(int i = 0; i < A.length; ++i) {
            if( i== 0) {
                res = A[0];
                prev = A[0];
            } else {
                if (prev > 0) {
                    prev = prev + A[i];
                } else {
                    prev = A[i];
                }
            }
            if (prev > res) {
                res = prev;
            }
        }
        return res;
    }
}

