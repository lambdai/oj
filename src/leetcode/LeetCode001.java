/**
 * http://leetcode.com/onlinejudge#question_1
 */
package leetcode;
import dyc.Misc;
import java.util.Arrays;

public class LeetCode001 {
    public int[] twoSum(int[] numbers, int target) {
	int[] newNumbers = new int[numbers.length];
	for(int i = 0; i< numbers.length; i++ ) {
	    newNumbers[i] = numbers[i] ;
	}
        Arrays.sort(newNumbers);
	int i=0,j=newNumbers.length-1;
	while(i != j){
	    int thisResult = newNumbers[i] + newNumbers[j];
	    if(thisResult == target) {
		return cal(numbers, newNumbers[i], newNumbers[j]);
	    }
	    if(thisResult > target) {
		j--;
	    } else {
		i++;
	    }
	}
	return null;
    }
    private int[] cal(int numbers[], int n1, int n2) {
	int[] result = new int[2];
	int left = 0;
	int i;
	for( i = 0; i < numbers.length; i++) {
	    if (numbers[i] == n1) {
		result[0] = i + 1;
		left = n2;
		break;
	    } else if( numbers[i] == n2) {
		result[0] = i + 1;
		left = n1;
		break;
	    } 
	}
	for( i = i+1; i <numbers.length; i++) {
	    if (numbers[i] == left ){
		result[1] = i + 1;
	    }
	}
	return result;
    }

    public static void main(String args[]){
	int [] numbers={7, 2, 11, 15};
	int target = 13;
	LeetCode001 solution = new LeetCode001();
	int [] result = solution.twoSum(numbers, target);
	Misc.printArray(result);
    }
	
}
