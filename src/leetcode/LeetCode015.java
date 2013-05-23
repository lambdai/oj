package leetcode;

import java.util.ArrayList;

import dyc.Misc;
public class LeetCode015 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        quickSort(num);
	ArrayList< ArrayList<Integer> > results = new ArrayList< ArrayList<Integer> >();
	for(int i = 2; i < num.length; i++){
	    if(i!=num.length-1) {
	        if(num[i]== num[i+1]) { continue;}
	    }
	    findSum(results, num, 0, i-1, -num[i]);
//	    if(!hasPre) { hasPre = true; preTarget = num[i];};
	}
	return results;
    }
    public void findSum(ArrayList< ArrayList<Integer>> results, int[] num, int indexL, int indexR, int target) {
	while(indexL < indexR) {
	    if(num[indexL] + num[indexR] == target) {
		ArrayList<Integer> l = new ArrayList<Integer>(3);
		l.add(num[indexL]); l.add(num[indexR]); l.add(-target);
		results.add(l);
	//	System.out.printf ("{%d,%d,%d}\n", num[indexL], num[indexR], -target);
		int preL = num[indexL];
		indexL ++;
		while( indexL < indexR && preL == num[indexL]) { indexL ++;}
	    } else {
		if(num[indexL] + num[indexR] < target) {
		    int preL = num[indexL];
		    indexL ++;
                    while (indexL < indexR && preL == num[indexL]) {
                        indexL++;
                    }
                } else {
                    // (num[indexL] + num[indexR] > target) {
                    int preR = num[indexR];
                    indexR--;
                    while (indexL < indexR && preR == num[indexR]) {
                        indexR--;
                    }
                }
            }

	}
    }


    public static void quickSort(int[] num) {
	quickSort(num, 0, num.length-1);
    }
    public static void quickSort(int[] num, int indexL, int indexR){
	if(indexR <= indexL) { return; }
	int sentinel = num[indexL];
	int indexSmall=indexL, indexSoFar;
	for(indexSoFar = indexSmall+1; indexSoFar <= indexR; indexSoFar++){
	    if(num[indexSoFar] < sentinel){
	        indexSmall ++;
		int temp = num[indexSmall];
		num[indexSmall] = num[indexSoFar];
		num[indexSoFar] = temp;
	    } 
	}
	num[indexL] = num[indexSmall];
	num[indexSmall] = sentinel;
	quickSort(num, indexL, indexSmall-1);
	quickSort(num, indexSmall+1, indexR);
    }
    		
    public static void main(String args[]) {
        int[] arr = {-2,0,1,1,2};
        //Misc.printArray(arr);
        quickSort(arr, 0, arr.length-1);
        LeetCode015 solution = new LeetCode015();
        solution.threeSum(arr);
        Misc.printArray(arr);
        System.out.println("done");
    }

}