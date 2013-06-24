package dyc;

import java.util.Arrays;
import java.util.List;

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
    public static void printByteArray(byte[] numbers){
        StringBuilder sb = new StringBuilder();
        for(int n: numbers){
            sb.append(n).append(' ');
        }
        sb.setCharAt(sb.length()-1, '\n');// (sb.length(), '\n');
        System.out.print(sb.toString());
    }
    
    public static void printArray(int[] numbers){
	StringBuilder sb = new StringBuilder();
	for(int n: numbers){
	    sb.append(n).append(' ');
	}
	sb.setCharAt(sb.length()-1, '\n');// (sb.length(), '\n');
	System.out.print(sb.toString());
    }
    
    public static void printArray(Integer[] numbers){
        StringBuilder sb = new StringBuilder();
        for(int n: numbers){
            sb.append(n).append(' ');
        }
        sb.setCharAt(sb.length()-1, '\n');// (sb.length(), '\n');
        System.out.print(sb.toString());
    }
    
    public static void printArray(int[] numbers, int offset, int len){
        if(len<=0){ return;}
        StringBuilder sb = new StringBuilder();
        for(int i =offset;i < offset+len;i++){
            sb.append(numbers[i]).append(' ');
        }
        sb.setCharAt(sb.length()-1, '\n');// (sb.length(), '\n');
        System.out.print(sb.toString());
    }
    
    
    
    public static <Item>void printList(List<Item> l){
        if(l.size()==0) { System.out.println("List Empty");}
        StringBuilder sb = new StringBuilder();
        for(Item n: l){
            sb.append(n).append(' ');
        }
        sb.setCharAt(sb.length()-1, '\n');// (sb.length(), '\n');
        System.out.print(sb.toString());
    }

    public static void main(String args[]) {
	int[] arr = { 1, 2, 8, 3, 2, 9};
	printArray(arr);
	//quickSort(arr, 0, arr.length-1);
	Arrays.sort(arr);
	printArray(arr);
    }
    
}