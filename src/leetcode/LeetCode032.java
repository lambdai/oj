package leetcode;

public class LeetCode032 {
    public int longestValidParentheses(String s) {
	int leftMax = leftLongest(s);
	int rightMax = rightLongest(s);
	return leftMax > rightMax? leftMax:rightMax;
        
    }

    public int leftLongest(String s){
	int longest = 0;
	int thisLen = 0;
	int pending = 0;
	for(int i = 0; i< s.length(); i++){
	    if(s.charAt(i) == '(') {
		pending ++;
		thisLen ++;
	    } else {
		pending --;
		thisLen ++;
		if(pending == 0) { 
		    if(longest < thisLen) { longest = thisLen;}
		} else {
		    if(pending < 0) {
			thisLen = 0;
			pending = 0;
		    }
		}
	    }
	}
	return longest;
    }

    public int rightLongest(String s){
	int longest = 0;
	int thisLen = 0;
	int pending = 0;
	for(int i = s.length()-1; i>=0; i--){
	    if(s.charAt(i) == ')') {
		pending ++;
		thisLen ++;
	    } else {
		pending --;
		thisLen ++;
		if(pending == 0) { 
		    if(longest < thisLen) { longest = thisLen;}
		} else {
		    if(pending < 0) {
			thisLen = 0;
			pending = 0;
		    }
		}
	    }
	}
	return longest;
    }

    public static void main(String args[]){
	LeetCode032 solution = new LeetCode032();
	System.out.println(solution.longestValidParentheses(")()())"));
    }
}