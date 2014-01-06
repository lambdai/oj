//http://oj.leetcode.com/problems/single-number-ii/
package newleetcode;

public class SingleNumber2 {
    public int singleNumber(int[] A) {
    	int lower = 0;
    	int higher = 0;
    	for (int i : A) {
    		higher |= (lower & i);
    		lower ^= i;
    		int isThree = higher & lower;
    		higher &= (~isThree);
    		lower &= (~isThree);
    	}
    	return lower;    	
    }
    
    public static void main(String args[]) {
    	System.out.println(new SingleNumber2().singleNumber(new int[] { 10, 0, 0, 10, 0, 1, 1, 3, 1, 10,  }));
    }
}
