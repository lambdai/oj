package leetcode;

public class LeetCode041 {
    public int firstMissingPositive(int[] A) {
	for(int i = 0 ; i < A.length; i ++ ) {
	    rotate(A, i);
	}
	for(int i = 0; i < A.length; i++) {
	    if(A[i] != i+1) {
		return i+1;
	    }
	}
	return A.length+1;
    }

    public void rotate(int[] arr, int i) {
	if(arr[i] == i+1) { return; }
	while (0 < arr[i] && arr[i] <= arr.length) {
	    int destIndex = arr[i] - 1;
	    if(arr[destIndex] == arr[i] ) { return; }
	    swap(arr, i, destIndex);
	}
    }

    private void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }

    public static void main(String args[]) {
	LeetCode041 solution = new LeetCode041();
	System.out.println(solution.firstMissingPositive(new int[]{3,4,-1,1}));
    }
}