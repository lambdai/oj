//http://oj.leetcode.com/problems/word-break-ii/
package newleetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
    	if (dict == null || dict.size() == 0) { return false; }
    	ACMata ac = new ACMata(dict.toArray(new String[0]));
    	ac.updateFailedField();
    	byte [] barray = s.getBytes();
    	boolean isWord[][] = new boolean[barray.length][barray.length];
    	ACNode node = ac.root;
    	Set<Integer> matches;
    	for(int i = 0; i < barray.length; ++i) {
    		ACNode preNode = null;
    		while(preNode == null || preNode != ac.root) {
    			if (node.nextNodes.containsKey(barray[i])) {
    				node = node.nextNodes.get(barray[i]);
    				matches = node.matches.keySet();
    	    		if(matches.size() > 0) {
    	    			for(int len : matches) {
    	    				isWord[i-len+1][i] = true;
    	    			}
    	    		}
    	    		break;
    			} else {
    				preNode = node;
    				node = node.failed;
    			}
    		}
    	}
    	/*
    	for(int i = 0; i < barray.length; ++i) {
    	 
    		for (int j = i; j < barray.length; ++j) {
    			if(isWord[i][j]) {
    				System.out.println(String.format("{%d, %d}", i, j));
    			}
    		}
    	}
    	*/
    	boolean ifCombine[] = new boolean[barray.length];
    	for(int i = 0; i < barray.length; ++i) {
    		for(int j = 0; j <=i; ++j) {
    			if(isWord[j][i] && (j==0 || ifCombine[j-1])) {
    				ifCombine[i] = true;
    			}
    		}
    	}
    	return ifCombine[barray.length-1];
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> strs = new HashSet<String>();
		strs.add("leet");
		strs.add("code");
		System.out.println(new WordBreak().wordBreak("leetcode", strs ));

	}

}


