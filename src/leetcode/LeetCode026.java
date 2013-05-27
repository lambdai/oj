package leetcode;

public class LeetCode026 {
    public int removeDuplicates(int[] A) {
	int iLeft, iRight, current;
	if(A.length <= 1) { return A.length;}
	iLeft = 0; iRight = iLeft;
	while(iRight < A.length) {
	    A[iLeft] = current = A[iRight]; iLeft ++;
	    while(iRight < A.length && current == A[iRight]) { iRight ++;}
	    if(iRight == A.length) { return iLeft;}
	}
        return iLeft;
    }

    public static void main(String args[]){
	LeetCode026 solution = new LeetCode026();
	System.out.println(solution.removeDuplicates(new int[]{1,1,2}));
	
    }
}