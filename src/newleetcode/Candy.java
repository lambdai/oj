//http://oj.leetcode.com/problems/candy/
package newleetcode;

public class Candy {
	public int candy(int[] ratings) {
		int sum = 1;
		
		int inc = 0;
		int phase = 0;
		int j = 1, i;
		int indextop = 0;
		while (j < ratings.length) {
			
			inc = 0;
			for (i = j; i < ratings.length; ++i) {
				if (phase == 0) {
					if (ratings[i] > ratings[i - 1]) {
						inc++;
						sum += (1+inc);
						indextop = i;
					} /*else if (ratings[i] == ratings[i - 1]) {
						sum += (1+inc);
						indextop = i;
					} */
					else {				
						phase = 1;
						if (ratings[i] < ratings[i-1]) {
							--inc;
						}
						//indextop = i - 1;
					}
					

				} else {
					if (ratings[i] < ratings[i - 1]) {
						if (ratings[i] < ratings[i - 1]) {
							inc--;
						}
					} else {
						break;
						// sum += doCalulation(j, i, indextop, ratings);

					}
				}
			}
			int acc = 1;
			int k;
			for (k = i - 1; k > indextop; --k) {
				sum += acc;
				acc += (ratings[k] < ratings[k-1]? 1 : 0);
			}
			if(inc < 0 && ratings[indextop] > ratings[indextop+1] ) {
				sum += (-inc);
			}
			j = i;
			phase = 0;
			indextop=i-1;
		}
		return sum;
    }
    /*
    int doCalulation(int ileft, int iright, int itop, int []ratings) {
    	int sum = 0;
    	int max = 0;
    	int candies = 1;
    	for(int i = 1; i <= itop; ++i) {
    		if(ratings[i] > ratings[i-1]) {
    			candies ++;
    			sum += candies;
    		} else if(ratings[i] == ratings[i-1]) {
    			sum += candies;
    		} else {
    			
    		}
    	}
    }
*/
	public static void main(String args[]) {
		System.out.println(new Candy().candy(new int[] {1,1,1,1}));
		System.out.println(new Candy().candy(new int[] {2,2,1}));
		
		System.out.println(new Candy().candy(new int[] {0}));
		System.out.println(new Candy().candy(new int[] {0,1}));
		System.out.println(new Candy().candy(new int[] {0,1,2}));
		System.out.println(new Candy().candy(new int[] {0,1,2,3}));
		System.out.println(new Candy().candy(new int[] {0,1,2,3,2}));
		System.out.println(new Candy().candy(new int[] {0,1,2,3,2,1}));
		System.out.println(new Candy().candy(new int[] {0,1,2,3,2,1,0}));
		System.out.println(new Candy().candy(new int[] {1,2,1,0,1,0}));
	}
}
