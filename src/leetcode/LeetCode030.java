package leetcode;

import java.util.ArrayList;

import dyc.Misc;

public class LeetCode030 {
    public ArrayList<Integer> findSubstring(String S, String[] L) {

	ArrayList<Integer> result = new ArrayList<Integer>(L.length);
	if(L.length == 0) { return result;}
	int partLen = L[0].length();
	int i,j;
	byte[] hashes = new byte[L.length];
	byte[] sHashes = new byte[S.length()];
	for(i =0; i < L.length; i++) {
	    hashes[i] = 0;
	    byte[] bytes = L[i].getBytes();
	    for(j=0; j<L[i].length(); j++){
		hashes[i] ^= bytes[j];
	    }
	}

	if(S.length() < partLen) { return result;}
	byte[] sBytes = S.getBytes();
	for(i = 1, sHashes[0] = sBytes[0]; i<partLen; i++){
	    sHashes[0] ^= sBytes[i];
	}

	for(i = 1; i<=S.length()-partLen; i ++) {
	    sHashes[i] = (byte) (sHashes[i-1] 
	            ^ sBytes[i-1] 
	                    ^ sBytes[i+partLen-1]);
	}
	Misc.printByteArray(sHashes);
	Misc.printByteArray(hashes);
	j = 0;
	nextPattern:
	for(i = 0; i < L.length; i++) {
	    nextPos:
	    while(j <= S.length()-partLen){
		if(sHashes[j] == hashes[i]) {
		    for(int k = 0; k<partLen; k++){
			if(L[i].charAt(k) != S.charAt(j+k)) {
			    j++;
			    continue nextPos;
			}
		    }
		    result.add(j);
		    j+=partLen; break; // to nextPattern
		}
		j++;
	    }
	}
	return result;

    }
    
    public static void main(String args[]) {
        LeetCode030 solution = new LeetCode030();
        //Misc.printList(
        //        solution.findSubstring("aaaaaaa", new String[]{"aaa","bbb","ccc"}));
        Misc.printList(
                solution.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
    }
}