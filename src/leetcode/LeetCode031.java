package leetcode;
import dyc.Misc;

public class LeetCode031 {
    public void nextPermutation(int[] num) {
	int maxValue=num[num.length-1]; 
	int i,j=0;
	for(i = num.length-2; i >=0; i--){
	    if(num[i] >= maxValue) {
		maxValue = num[i];
	    } else {
		break;
	    }
	}
	if(i == -1) { 
	    reverse(num,0,num.length-1);
	    return;
	}
	int sentinel = num[i];
	for(j=num.length-1; j!=i; j--) {
	    if(num[j]>sentinel) { break;}
	}
	int temp = num[i];
	num[i] = num[j];
	num[j] = temp;
	reverse(num, i+1, num.length-1);
    }
    public void reverse(int[] arr, int from, int to){
	int temp;
	for(;from < to; from ++, to--){
	    temp = arr[from];
	    arr[from] = arr[to];
	    arr[to] = temp;
	}
    }
    public static void main(String args[]){
	LeetCode031 solution = new LeetCode031();
	int[] num = new int[] {1,1,5};
	solution.nextPermutation(num);
	Misc.printArray(num);
    }
       
}