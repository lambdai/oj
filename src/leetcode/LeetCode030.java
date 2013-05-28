package leetcode;

public class LeetCode030 {
    public ArrayList<Integer> findSubstring(String S, String[] L) {

	ArrayList<Integer> result = new ArrayList<Integer>(L.length);
	if(L.length == 0) { return result;}
	int partLen = L[0].length();
	for(int i =0; i < L.length; i++) {
	    byte[] bytes = L[i].getBytes();
	    for(int j=1, hashes[i] = bytes[0]; j<L[i].length(); j++){
		hashes[i] ^= bytes[j];
	    }
	}

	if(S.length() < partLen) { return result;}
	bytes[] sBytes = new byte[S.length];
	for(int i = 1, sHashes[0] = sBytes[0]; i<partLen; i++){
	    sHashes[0] ^= sBytes[i];
	}

	for(int i = 1; i<=S.length()-partLen+1; i ++) {
	    sHashes[i] = sHashes[i-1] ^ sBytes[i-1] ^ sBytes[i+partLen-1];
	}

	int j = 0;
	nextPattern:
	for(int i = 0; i < L.length; i++) {
	    nextPos:
	    while(j <= L.length-partLen){
		if(sHashes[j] == hashes[i]) {
		    for(int k = 0; k<partLen; k++){
			if(L[i][k] != S[j]) {
			    j++;
			    
			    continue nextPos;
			}
		    }
		    result.add(j);
		    i++; j++; break; // to nextPattern
		}
		j++;
	    }
	}
	return result;

    }
}