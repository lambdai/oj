package leetcode;


public class LeetCode003 {
    public int lengthOfLongestSubstring(String s) {
	int largest = -1, start =0, end =0;
	char x = 0;
        boolean hasChar[] = new boolean[256];
	for(int i = 0; i < hasChar.length; i++) { hasChar[i] = false;}
        for(end =0; end< s.length(); end++) {
	    x = s.charAt(end);
	    if(hasChar[x]){
		int thisLen = end-start;
		if(largest < thisLen) { largest = thisLen;}
		while(true){
		    if(s.charAt(start) != x){
			hasChar[s.charAt(start)]=false;
			start ++;
		    } else {
			start ++;
			break;
		    }
		}
	    } else {
		hasChar[x] = true;
	    }
	}
        
        int finallen = end-start;
        return largest > finallen? largest:finallen;
    }

    public static void main(String args[]) {
        System.out.println(new LeetCode003()
                .lengthOfLongestSubstring("inprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparating"));
    }
}
