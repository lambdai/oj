package leetcode;
import dyc.Misc;

import java.util.Arrays;

import java.util.ArrayList;

public class LeetCode040 {
    public static ArrayList<ArrayList<Integer>> resultSet;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
	Arrays.sort(candidates);
	resultSet = new ArrayList<ArrayList<Integer>>();
	combinationSum(candidates, 0, target, new ArrayList<Integer>());
	return resultSet;
    }

    public void combinationSum(int[] candidates, int offset, int target, ArrayList<Integer> preList) {
        assert(target > 0);
	if(offset >= candidates.length) { return; }
	ArrayList<Integer> oldPrefix = preList;
	ArrayList<Integer> newPrefix ;
	if(target == candidates[offset]) {
	    ArrayList<Integer> result = (ArrayList<Integer>) preList.clone();
	    result.add(candidates[offset]);
	    resultSet.add(result);
	    //Misc.printArray(result.toArray(new Integer[]{}));
	}
	if(target > candidates[offset]) {
	    newPrefix = (ArrayList<Integer>) oldPrefix.clone();
            newPrefix.add(candidates[offset]);
            combinationSum(candidates, offset+1, target-candidates[offset], newPrefix);
	    int nextOffset = offset + 1;
	    while(nextOffset < candidates.length && candidates[nextOffset] == candidates[offset]) {
	        nextOffset ++;
	    }
	    if(nextOffset < candidates.length) {
	        combinationSum(candidates, nextOffset, target, oldPrefix);
	    }
	   
	}	
    }

    public static void main(String[] args) {
	LeetCode040 solution = new LeetCode040();
	solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}