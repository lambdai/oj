package leetcode;

import dyc.Misc;

public class LeetCode034 {
    public int[] searchRange(int[] A, int target){
	return searchRange(A, 0, A.length-1,target, new int[]{-1,-1});
    }
    public int[] searchRange(int[] nums, int start, int end, int target, int result[]){
	// short range
	if(end - start < 3){
	    int j = 0;
	    for(int i = start; i<= end; i++){
		if(nums[i] == target){
		    result[j] = i;
		    j=1;
		    result[j] = i;
		}
	    }
	    return result;
	}
	// long range
	int medIndex = start + (end-start)/2;
	if(nums[medIndex] == target){
	    findLeftmostTarget(nums, start, medIndex, target, result);
	    findRightmostTarget(nums, medIndex, end,   target, result);
	    return result;
	} else if(nums[medIndex] < target){
	    return searchRange(nums, medIndex+1, end, target, result);
	} else {
	    return searchRange(nums, start, medIndex-1, target, result);
	}
    }

    public void findRightmostTarget(int[] nums, int start, int end, int target, int[] result){
	int medIndex = start+(end-start)/2;
	if(start +1 >= end){
	    result[1] = nums[end] == target? end:start;
	    return;
	}
	if(nums[medIndex] > target) {
	    findRightmostTarget(nums, start, medIndex-1, target, result);
	} else {
	    findRightmostTarget(nums, medIndex, end, target, result);
	}
    }

    public void findLeftmostTarget(int[] nums, int start, int end, int target, int[] result) {
	int medIndex = end - (end-start)/2;
	if(start+1 >= end) {
	    result[0] = nums[start] == target? start: end;
	    return;
	}
	if(nums[medIndex] < target){
	    findLeftmostTarget(nums, medIndex+1, end, target, result);
	} else {
	    findLeftmostTarget(nums, start, medIndex, target, result);
	}
    }

    public static void main(String[] args){
	LeetCode034 solution = new LeetCode034();
	Misc.printArray(solution.searchRange(new int[]{1,2,3,3,3,3,4,5,9},3));
    }
}