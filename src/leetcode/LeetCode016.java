package leetcode;
import dyc.Misc;
public class LeetCode016 {
    
    public int threeSumClosest(int[] num, int target) {
	quickSort(num);
	int diff = Integer.MAX_VALUE;
	int closestResult = 0;
	for(int j=2; j< num.length; j++) {
	    int indexL=0, indexR=j-1;
	    while(indexL < indexR) {
		int sum = num[indexL] + num[indexR] + num[j] - target ;
		if(diff > Math.abs(sum)) { 
		    diff = Math.abs(sum);
		    closestResult = sum+target;
		}
		if(sum == 0) { return target;}
		if(sum < 0) {
		    indexL++;
		} else {
		    indexR--;
		}
	    }
	}
	return closestResult;
    }
    
    public static void quickSort(int [] num){
	quickSort(num,0,num.length-1);
    }
    public static void quickSort(int[] num, int indexL, int indexR){
	if(indexL >= indexR) { return; }
	int sentinel = num[indexL];
	int ileft = indexL+1, iright = indexR;
	while(ileft<iright){
	    while(ileft < iright && num[ileft] <= sentinel) { ileft ++; }
	    while(ileft < iright && num[iright] >= sentinel) { iright --; }
	    if(ileft == iright) { 
		break;
	    } else {
		int temp = num[ileft];
		num[ileft] = num[iright];
		num[iright] = temp;
	    }
	}
	int dest;
        if(num[ileft] <= sentinel) {
            dest = ileft;
        } else {
            dest = ileft -1;
        }
        num[indexL] = num[dest];
        num[dest] = sentinel;
        quickSort(num, indexL, dest-1);
        quickSort(num, dest+1, indexR);
    }

    public static void main(String[] args) {
	int[] arr = {-1,2,1,-4};
	
        quickSort(arr, 0, arr.length-1);
        
        LeetCode016 solution = new LeetCode016();
        System.out.println(solution.threeSumClosest(arr, 1));
    }

    
}