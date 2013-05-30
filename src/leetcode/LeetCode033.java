package leetcode;

public class LeetCode033 {
    public int search(int[] A, int target) {
	return gapSearch(A, 0, A.length-1, target);
    }
    
    public int gapSearch(int[] nums, int begin, int end, int target){
	//int current = -1;
	if(end-begin<3){
	    return tinySearch(nums, begin, end, target);
	}
	int medIndex = begin + (end-begin)/2;
	if(nums[medIndex] == target) { return medIndex;}
	if(nums[medIndex] > nums[begin]) {
	    if(nums[medIndex] > target && target >= nums[begin] ){
		return gapSearch(nums, begin, medIndex-1, target); //binsearch
	    } else {
		return gapSearch(nums, medIndex+1, end, target); //gapsearch
	    }
	} else {
	    if(nums[medIndex] < target && target <= nums[end]){
		return gapSearch(nums, medIndex+1, end, target); //binsearch
	    } else {
		return gapSearch(nums, begin, medIndex-1, target); //gapsearch
	    }
	}
	
    }

    public int tinySearch(int[] nums, int begin, int end, int target){
	for(int current = begin;current <= end; current++){
	    if(nums[current] == target){ return current;}
	}
	return -1;
    }

    public static void main(String[] args){
	LeetCode033 solution = new LeetCode033();
	System.out.println(solution.search(new int[]{4,5,6,7,0,1,2},1));
    }
}