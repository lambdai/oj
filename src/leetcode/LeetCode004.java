package leetcode;

import dyc.Misc;

public class LeetCode004 {

    public double findMedianSortedArrays(int A[], int B[]) {
        int sumlen = A.length + B.length;
        if (sumlen % 2 == 0) {
            return (findOffsetSortArrays(A, 0, A.length, B, 0, B.length,
                    sumlen / 2) + findOffsetSortArrays(A, 0, A.length, B, 0,
                    B.length, sumlen / 2 - 1)) / 2.0;
        } else {
            return findOffsetSortArrays(A, 0, A.length, B, 0, B.length,
                    sumlen / 2);
        }
        // return findOffsetSortArrays(A, 0, A.length, B, 0, B.length, (A.length
        // + B.length)/2);
    }

    public int findOffsetSortArrays(int a[], int s0, int len0, int b[], int s1,
            int len1, int offset) {

        // Misc.printArray(a, s0, len0);
        // Misc.printArray(b, s1, len1);
        // System.out.printf("%d\n", offset);
        // if(len0+len1)
        if (len0 <= 0) {
            return findOffsetSortArray(b, s1, len1, offset);
        }
        if (len1 <= 0) {
            return findOffsetSortArray(a, s0, len0, offset);
        }

        if (len0 > offset) {
            len0 = offset + 1;
        }
        if (len1 > offset) {
            len1 = offset + 1;
        }

        int med0 = len0 / 2, med1 = len1 / 2;
        if (med0 + med1 + 2 > offset + 1) {
            if (a[s0 + med0] > b[s1 + med1]) {
                return findOffsetSortArrays(a, s0, med0, b, s1, len1, offset);
            } else {
                return findOffsetSortArrays(a, s0, len0, b, s1, med1, offset);
            }

        } else {
            if (a[s0 + med0] > b[s1 + med1]) {
                return findOffsetSortArrays(a, s0, len0, b, s1 + med1 + 1, len1
                        - med1 - 1, offset - med1 - 1);
            } else {
                return findOffsetSortArrays(a, s0 + med0 + 1, len0 - med0 - 1,
                        b, s1, len1, offset - med0 - 1);
            }
        }
    }

    public int findOffsetSortArray(int a[], int s0, int len0, int offset) {
        // System.out.printf("Answer: %d\n", a[offset+s0]);
        return a[offset + s0];
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {
            3, 4
        };
        System.out.println(new LeetCode004().findMedianSortedArrays(a, b));
    }

}
