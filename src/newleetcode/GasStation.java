//http://oj.leetcode.com/problems/gas-station/
package newleetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int len = gas.length;
    	int reach[] = new int[len];
    	for(int i = 0; i< len; i++) {
    		reach[i] = -1;
    	}
    	int i = -1;
    	for(int k = len; k != 0; --k) {
    		i = k %len;
    		int pos = i;
    		if(reach[i] != -1) {
    			//DO judge;
    			return -1;
    		}
    		// reach[i] == -1, we have never process this point
			while (true) {
				if (gas[pos] < cost[pos]) {
					reach[i] = pos;
					break;
				} else {
					int newpos = (pos + 1) % len;
					if(newpos == i) {
						return i;
					}
					if (reach[newpos] != -1) {
						gas[reach[newpos]] = (gas[pos] - cost[pos])
								+ gas[reach[newpos]];
						reach[i] = reach[newpos];
					} else {
						gas[newpos] = (gas[pos] - cost[pos]) + gas[newpos];
						reach[i] = newpos;
					}
					pos = reach[i];
				}
			}
     		
    	}
    	return -1;
    }
    
    public static void main(String args[]) {
    	System.out.println(new GasStation().canCompleteCircuit(new int[]{5, 4}, new int[]{10,9}));
    }
}
