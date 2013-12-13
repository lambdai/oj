//http://oj.leetcode.com/problems/jump-game/
package newleetcode;

public class JumpGame {
    public boolean canJump(int[] A) {
	int sofar = 0;
	int dest = A.length;
	int current = 0;
	while (sofar < dest) {
	    if (current <= sofar) {
		int reach = current + A[current];
		if (sofar < reach) {
		    sofar = reach;
		}
	    } else {
		return sofar >= dest;
	    }
	    ++current;
			
	}
	return sofar >= dest;
    }
    
    public static void main(String args) {
    	
    }
}