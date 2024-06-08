class Solution {
    public int maxProfit(int[] prices) 
    {
        int minm = prices[0];
        int profit = 0;
        for(int val : prices)
        {
            profit = Math.max(profit, val - minm);
            minm = Math.min(minm, val);
        }
        return profit;
        
    }
}