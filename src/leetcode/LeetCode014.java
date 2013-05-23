package leetcode;

public class LeetCode014 {
    public String longestCommonPrefix(String[] strs) {
	StringBuilder sb = new StringBuilder();
	try {
	    fin: for(int j = 0; j < strs[0].length(); j++) {
		char a = strs[0].charAt(j);
		for(int i = 1; i < strs.length; i++) {
		    if(strs[i].charAt(j) != a) {
			break fin;
		    }
		}
		sb.append(a);
	    }
	}
	catch (Exception e) {}
	return sb.toString();
    }

    public static void main(String args[]){
	String[] strs = {"abc", "abc"};
	LeetCode014 solution = new LeetCode014();
	System.out.println(solution.longestCommonPrefix(strs));
	System.out.println("done");
    }
}