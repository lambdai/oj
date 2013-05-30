package leetcode;

public class LeetCode035 {
    public int searchInsert(int[] A, int target) {
	return searchInsert(A, 0, A.length-1, target);
    }

    public int searchInsert(int[] nums, int start, int end, int target){
	if(end-start <2){
	    int insertPos;;
	    for(insertPos = start; insertPos <= end; insertPos++){
		if(nums[insertPos] >= target){
		    return insertPos;
		}
	    }
	    return insertPos;
	}
	
	int medIndex = start + (end-start)/2;
	if(nums[medIndex] >= target) {
	    return searchInsert(nums, start, medIndex-1, target);
	} else {
	    return searchInsert(nums, medIndex, end, target);
	}
    }

    public static void main(String[] args){
	LeetCode035 solution = new LeetCode035();
	System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 5));
	System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
	System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7));
	System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 0));
    }
}