package org.example.slidingWindow;

public class BuySellStocks {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 1, 0, 1, 2};
        System.out.println(maxProfitDP(arr));
    }

    //Time complexity: O(n square)
    //Space complexity: O(1)
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit=0;
        for(int i=0;i<prices.length; i++){
            int buy = prices[i];
            for(int j=i+1;j<prices.length; j++){
                int diff = prices[j] - buy;
                if(diff > maxProfit){
                    maxProfit = diff;
                }
            }
        }
        return maxProfit;
    }

    //Time complexity: O(n)
    //Space complexity: O(1)
    // 2 pointer
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = left + 1;
        while (left < right && right < prices.length) {
            int buy = prices[left];
            int sell = prices[right];

            if (buy < sell) {
                int currProfit = sell - buy;
                maxProfit = Math.max(currProfit, maxProfit);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    //Time complexity: O(n)
    //Space complexity: O(1)
    //Dynamic Programming
    public static int maxProfitDP(int[] prices){
        int minBuy = prices[0];
        int maxProfit = 0;

        for(int sell : prices){
            minBuy = Math.min(sell, minBuy);
            maxProfit = Math.max(maxProfit, sell - minBuy);
        }
        return maxProfit;
    }
}
