//http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
package newleetcode;

public class LongestNonRepeatSubstring {
    public int lengthOfLongestSubstring(String s) {
	if(s == null || s.length() == 0) { return 0;}
        char[] str = s.toCharArray();
	int i = 0;
	int lastOccur[] = new int[256];
	for (int j = 0; j<256; ++j) {
	    lastOccur[j] = -1;
	}
	int longest = 0;
	int longest_begin = 0;
	int current_begin = 0;
	for(i = 0;i<str.length; ++i) {
	    if (lastOccur[str[i]] >= 0) {
		int clen = i - current_begin;
		if(longest < clen) {
		    longest = clen;
		    longest_begin = current_begin;
		}
		for(int j=current_begin; j < lastOccur[str[i]]; ++j) {
		    lastOccur[str[j]] = -1;
		}
		current_begin = lastOccur[str[i]] +1;
	    } 
	    lastOccur[str[i]]= i;

	}
	if(i-current_begin > longest) {
	    longest = i-current_begin;
	    longest_begin = current_begin;
	}
	return longest;
    }
    public static void main(String[] args) {
    	System.out.println(new LongestNonRepeatSubstring().lengthOfLongestSubstring("bbbbb"));
    }
}