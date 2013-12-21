//http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
package newleetcode;

public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length < 2) { return 0;}
    	int minl = prices[0];
    	int profit[] = new int[prices.length];
    	profit[0] = 0;
    	for (int i = 1; i < prices.length; ++i) {
    		if (minl > prices[i]) {
    			minl = prices[i];
    			profit[i]=profit[i-1];
    		} else {
    			profit[i] = prices[i] - minl > profit[i-1] ? prices[i]-minl : profit[i-1];
    		}
    	}
    	int maxr = prices[prices.length -1];
    	int maxprofit = 0;
    	int preprofitr = 0;
    	for (int j = prices.length-1; j >= 0; --j) {
    		if (maxr < prices[j]) {
    			maxr = prices[j];
    		} else {
    			preprofitr = maxr-prices[j];
    		}
    		maxprofit = preprofitr + profit[j] > maxprofit ? preprofitr + profit[j] : maxprofit;
    		//System.out.printf("day %d: l-r profit %d,  r-l profit %d\n", j, profit[j], preprofitr );
    	}
    	return maxprofit;
    }
    
	public static void main(String[] args) {
		System.out.println(new BestTimeToBuyAndSellStock3().maxProfit(new int[]{6,1,3,2,4,7}));

	}

}
