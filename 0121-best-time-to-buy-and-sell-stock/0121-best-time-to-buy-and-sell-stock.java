class Solution {
    public int maxProfit(int[] prices) {
        int buyIndex = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit;
            if (prices[i] < prices[buyIndex]) {
                buyIndex = i;
            } else if ((profit = prices[i] - prices[buyIndex]) > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}