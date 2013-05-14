package dyc;

import java.util.Arrays;

public class Misc {
    public static void quickSort(int[] numbers, int start, int end) {
	if(start >= end) { return; }
	int sen = numbers[start];
	int less = start + 1, sofar = less, temp;
	while(sofar < end) {
	    if(numbers[sofar] < sen) {
		temp = numbers[sofar];
		numbers[sofar] = numbers[less];
		numbers[less] = temp;
		less ++;
	    }
	    sofar++;
	}
	numbers[start] = numbers[less-1];
	numbers[less-1] = sen;
	quickSort(numbers, start, less -2);
	quickSort(numbers, less, end);
    }

    public static void printArray(int[] numbers){
	StringBuilder sb = new StringBuilder();
	for(int n: numbers){
	    sb.append(n).append(' ');
	}
	sb.setCharAt(sb.length()-1, '\n');// (sb.length(), '\n');
	System.out.println(sb.toString());
    }

    public static void main(String args[]) {
	int[] arr = { 1, 2, 8, 3, 2, 9};
	printArray(arr);
	//quickSort(arr, 0, arr.length-1);
	Arrays.sort(arr);
	printArray(arr);
    }
    
}