
public class BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }

        return sell[sell.length - 1];
    }

    public static void main(String args[]) {
        BestTimetoBuyandSellStockwithTransactionFee btbsst
                = new BestTimetoBuyandSellStockwithTransactionFee();
        int[] prices = new int[]{4, 5, 2, 4, 3, 3, 1, 2, 5, 4};
        System.out.println(btbsst.maxProfit(prices, 1));
    }
}
