
public class BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                if (prices[j] < prices[i]) {
                    if (j != 0) {
                        dp[i] = Math.max(dp[i], dp[j - 1]
                                + prices[i] - prices[j] - fee);
                    } else {
                        dp[i] = Math.max(dp[i], prices[i] - prices[j] - fee);
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String args[]) {
        BestTimetoBuyandSellStockwithTransactionFee btbsst
                = new BestTimetoBuyandSellStockwithTransactionFee();
        int[] prices = new int[]{4, 5, 2, 4, 3, 3, 1, 2, 5, 4};
        System.out.println(btbsst.maxProfit(prices, 1));
    }
}
