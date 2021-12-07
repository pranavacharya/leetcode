
public class BestTimeToBuyAndSellStocks {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    public static void main(String args[]) {
        BestTimeToBuyAndSellStocks bttbass = new BestTimeToBuyAndSellStocks();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bttbass.maxProfit(prices));
    }
}
