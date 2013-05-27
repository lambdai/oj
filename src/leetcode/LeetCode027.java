package leetcode;

public class LeetCode027 {
    public int removeElement(int[] A, int elem) {
	if(A.length == 0) { return 0;}
	int iLeft = 0, iRight = A.length-1;
	while(iLeft < iRight) {
	    while(iLeft < iRight && A[iLeft] != elem) {iLeft++;}
	    while(iLeft < iRight && A[iRight] == elem) {iRight --;}
	    if(iLeft != iRight) { 
		A[iLeft] = A[iRight];
		iRight--;
	    } else {
		break;
	    }
	}
	if(A[iLeft] == elem) { 
	    return iLeft; 
	} else {
	    return iLeft+1;
	}
    }
	
}
