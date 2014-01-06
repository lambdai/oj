//http://oj.leetcode.com/problems/pascals-triangle/
package newleetcode;

import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	if(numRows < 1) { return ret;}
	ArrayList<Integer> preline = null;
	for(int i = 1; i<= numRows; i++) {
	    ArrayList<Integer> line = new ArrayList<Integer>(i);

	    
	    if (preline != null) {
		int preElement = 0;
		for(int element: preline) {
		    line.add(preElement+element);
		    preElement = element;
		}
	    }
	    line.add(1);
	    ret.add(line);
	    preline = line;
	}
	return ret;
    }	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> ret = new PascalTriangle().generate(5);
		return;
	}

}
