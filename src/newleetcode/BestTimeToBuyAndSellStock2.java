//http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
package newleetcode;

public class BestTimeToBuyAndSellStock2 {
	public int maxProfit(int[] prices) {
		if (prices.length < 2) { return 0; }
		int sum = 0;
		int min = prices[0];
		
		for (int i = 1; i < prices.length; ++i) {
			if (min < prices[i]) {
				sum += (prices[i] - min);
			} 
			min = prices[i];
		}
		return sum;
        
    }


	public static void main(String[] args) {
		System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(new int[]{1,2}));

	}

}
