package leetcode;
import dyc.Misc;

import java.util.Arrays;

import java.util.ArrayList;

public class LeetCode039 {
    public static ArrayList<ArrayList<Integer>> resultSet;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	Arrays.sort(candidates);
	resultSet = new ArrayList<ArrayList<Integer>>();
	combinationSum(candidates, 0, target, new ArrayList<Integer>());
	return resultSet;
    }

    public void combinationSum(int[] candidates, int offset, int target, ArrayList<Integer> preList) {
        assert(target > 0);
	if(offset >= candidates.length) { return; }
	ArrayList<Integer> oldPrefix = preList;
	ArrayList<Integer> newPrefix = (ArrayList<Integer>) oldPrefix.clone();
	for(; target > candidates[offset]; target -= candidates[offset]) {
	    newPrefix = (ArrayList<Integer>) oldPrefix.clone();
	    newPrefix.add(candidates[offset]);
	    combinationSum(candidates, offset+1, target, oldPrefix);
	    oldPrefix = newPrefix;
	}
	if(target == candidates[offset]) {
	    newPrefix.add(candidates[offset]);
	    resultSet.add(newPrefix);
	    Misc.printArray(newPrefix.toArray(new Integer[]{}));
	}
    }

    public static void main(String[] args) {
	LeetCode039 solution = new LeetCode039();
	solution.combinationSum(new int[]{2,3,6,7}, 7);
    }
}