//Given an array prices[] of length n, representing 
// the prices of the stocks on different days. The task is to 
// find the maximum profit possible by buying and selling the stocks 
// on different days when at most one transaction is allowed. 
// Here one transaction means 1 buy + 1 Sell.
 //If it is not possible to make a profit then return 0.
 class Solution {

    public int maximumProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            // Check profit if sold today
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            // Update minimum price so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;  // returns 0 if no profit possible
    }
}