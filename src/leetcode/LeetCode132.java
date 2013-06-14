package leetcode;

public class LeetCode132 {
    static byte[] bytes;
    static int minCuts[][];
    static int count = 0;
    public int minCut(String s) {
	bytes = s.getBytes();
	int len = s.length();
	minCuts = new int[len][len];
	boolean[][] isPalin = new boolean[len][len]; 
	for(int round = 0; round < len; round ++){
	    for(int i = 0; i < len-round; i++) {
	        int j = i+round;
	        if(i == j){
	            isPalin[i][j] = true;
	        } else {
	            isPalin[i][j] = 
	                    bytes[i] == bytes[j] &&
	                    ((j-i == 1) || isPalin[i+1][j-1]);
	        }
	    }
	}
	int minCut[] = new int[len+1];
	minCut[0] = -1;
	for(int k = 0; k < len; k++){
	    minCut[k+1] = Integer.MAX_VALUE;
	    for(int l = 0; l <=k; l++){
	        if(isPalin[l][k]){
	            minCut[k+1] = minCut[k+1] > minCut[l]+1 ? minCut[l] +1: minCut[k+1];
	        }
	    }
	}
	return minCut[len];
	/*
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len; j++) {
                minCuts[i][j] = -1;
            }
            if (i != 0) {
                minCuts[i][i - 1] = -1;

            }
            minCuts[i][i] = 0;
        }
//	return minCut(0, len-1);

        for(int i = 0;i < len; i++)
	for(int round =1; round <= len-1; round ++){
	    for(int i = 0; i < len-round; i++){
		int min = Integer.MAX_VALUE;
		if(isPalin(i, i+round, bytes, minCuts)){
		    minCuts[i][i+round] = 0;
		} else {
		    for(int cut = i; cut <i+round; cut++){
			int thisCut = minCuts[i][cut]+minCuts[cut+1][i+round]+1;
			if(thisCut < min){
			    minCuts[i][i+round] = thisCut;
			    min = thisCut;
			}
		    }
		}
	    }
	}
	return minCuts[0][len-1];
	*/
    }

    int minCut(int begin, int end){
        if(begin >= end) {
            minCuts[begin][end] = 0;
            return 0;
        }
        if(minCuts[begin][end] >= 0){
            return minCuts[begin][end];
        } 
        
        
        int min= Integer.MAX_VALUE;
        if(bytes[begin] == bytes[end]){
            min = minCut(begin+1, end-1);
            if(min <= 0){
                minCuts[begin][end] = 0;
                return 0;
            }
            minCuts[begin][end] = min + 2;
            min = min + 2;
        }
        
        for(int i = begin; i< end; i++) {
            int result= minCut(begin, i) + minCut(i+1, end) + 1;
            if( result < min) {
                minCuts[begin][end] = result;
                min = result;
            }
            if(result == 1) { 
                return 1;
            }
        }
        count ++;
        return min;
    }
    boolean isPalin(int begin, int end, byte[] bytes, int[][] minCuts){
	if(bytes[begin] == bytes[end]){
	    return minCuts[begin+1][end-1] == 0;
	}
	return false;
    }
    
    public static void main(String[] args){
        LeetCode132 solution = new LeetCode132();
        System.out.println(solution.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
        //System.out.println(solution.minCut("abb"));
        //System.out.println(count);
    }
    
}