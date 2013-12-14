package newleetcode;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
    	if(prices.length < 2) { return 0;}
    	int lowestSoFar = prices[0];
    	int profit = 0;
    	for(int i = 1; i< prices.length; i++) {
    		if(lowestSoFar > prices[i]) {
    			lowestSoFar = prices[i];
    		} else if (prices[i] - lowestSoFar > profit) {
    			profit = prices[i] - lowestSoFar;
    		}
    	}
    	return profit;
    }
}
