package leetcode;

public class LeetCode005 {
    public String longestPalindrome(String s) {
	int max = -1, indexL=0, indexR=0;
	int slen = s.length();
	int j = 0;
	for(int i = 0; i < slen; i++){
	    for(j = 0; i-j >=0 && i+j < slen; j++){
		if(s.charAt(i-j) != s.charAt(i+j)) { break; }
		if(2*j+1 > max){
		    max = 2*j+1;
		    indexL = i-j;
		    indexR = i+j;
		}
	    }
	    for(j = 0; i-j >= 0 && i+j+1 < slen; j++){
		if(s.charAt(i-j) != s.charAt(i+j+1)){ break;}
		if(2*j+2 > max){
		    max = 2*j+2;
		    indexL = i-j;
		    indexR = i+j+1;
		}
	    }
	}
	if(max == -1) { return new String();}
	return s.substring(indexL, indexR+1);
    }
    
    public static void main(String[] args){
	LeetCode005 solution = new LeetCode005();
	System.out.println(solution.longestPalindrome("aab"));
	System.out.println("done");
    }
}