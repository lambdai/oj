package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode017 {
    public final static Map<Character,String[]> map = new HashMap<Character,String[]>();
    public final static char[] chars = {1,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ','+', '#'};
    public final static int[]  offset = new int[256];
    public final static int[] lens = new int[256];
    static {
	//map.push('2',{'a','b','c'});
	//map.push('3',{'d','e','f'});
	offset['2'] = 1;
	offset['3'] = 4;
	offset['4'] = 7;
	offset['5'] = 10;
	offset['6'] = 13;
	offset['7'] = 16;
	offset['8'] = 20;
	offset['9'] = 23;
	offset['0'] = 27;
	lens['2'] = 3;
	lens['3'] = 3;
	lens['4'] = 3;
	lens['5'] = 3;
	lens['6'] = 3;
	lens['7'] = 4;
	lens['8'] = 3;
	lens['9'] = 4;
	lens['0'] = 1;
    }
    public ArrayList<String> letterCombinations(String digits) {
        int eachOffset[] = new int[digits.length()];
	int i = 0,j;
	int ending = 1;
	boolean hasComb = false;
	ArrayList<String> result = new ArrayList<String>(100);
	int eachResultLen = digits.length();
	int indexes[] = new int[digits.length()];
	int indexMax[] = new int[digits.length()];
	for(j = 0; j < digits.length(); j++) {

	    char c = digits.charAt(j);
	    if(lens[c] > 0) {
		hasComb = true;
		ending *= lens[c];
		eachOffset[j] = offset[c];
		indexes[j] = 0;
		indexMax[j] = lens[c];
	    }
	}
	if(!hasComb) { result.add(new String());return result;}
	
	StringBuilder sb = new StringBuilder(digits.length());
	
	for(i = 1; i<= ending; i++){
	    sb.setLength(0);
	    int carrier = 1;
	    for(j=0; j<eachResultLen; j++){
	        sb.append(chars[eachOffset[j]+indexes[j]]);
		indexes[j] += carrier;
		if(indexes[j] == indexMax[j]) {
		    indexes[j] = 0;
		    carrier = 1;
		} else {
		    carrier = 0;
		}		
	    }
	    result.add(sb.toString());
	    //System.out.println(sb.toString());
	}
	return result;
    }
    
    public static void main(String [] args){
        LeetCode017 solution = new LeetCode017();
        solution.letterCombinations("23");
        System.out.println("done");
    }
    
}
