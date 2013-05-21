package leetcode;

public class LeetCode007 {
    public int reverse(int x){
	boolean isPos = x >=0;
	if(!isPos){
	    x = -x;
	}
	int result=0;
	while(x > 0) {
	    int left = x%10;
	    result = result * 10 + left;
	    x = x/10;
	}
	return isPos? result : -result;

    }
}