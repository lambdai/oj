package leetcode;

public class LeetCode009 {
    public boolean isPalindrome(int x) {
	int b=0,y=x;
	if(y<0) { return false; }
	if(y<10) { return true; }
	int power = 1;
	while(y>0){
	    b++;
	    y /= 10;
	    if(b!=1){
	        power*=10;
	    }
	}
	
	return isPalindrome(x, b, power);
    }
    public boolean isPalindrome(int x, int b, int base){
	if(b==1||b==0) { return true; }
	int rightmost = x % 10;
	
	if(x/base == rightmost){
	    return isPalindrome((x%base)/10, b-2, base/100);
	}
	return false;
    }

    public static void main(String args[]){
	LeetCode009 solution = new LeetCode009();
	System.out.printf("%d:%b\n", 101, solution.isPalindrome(10011));
    }
}