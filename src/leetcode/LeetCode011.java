package leetcode;

public class LeetCode011 {
    public int maxArea(int[] height) {
	if(height.length < 2) { return -1;}

	int indexL = 0, indexR = height.length-1;
	int result = -1 ;
	while(indexL < indexR) {
	    boolean isLeftLess = height[indexL] < height[indexR];
	    int minHeight = height[isLeftLess?indexL:indexR];
	    int current = minHeight * (indexR-indexL);
	    result = current > result ? current : result;
	    if(isLeftLess) {
		while(height[indexL] <= minHeight && indexL < indexR) {
		    indexL ++;
		}
	    } else {
		while(height[indexR] <= minHeight && indexL < indexR){
		    indexR --;
		}
	    }
	}
	return result;
    }

    public static void main(String args[]){
	LeetCode011 solution = new LeetCode011();
	int heights[] = {1,2,3,4,5};
	System.out.println(solution.maxArea(heights));
    }
}