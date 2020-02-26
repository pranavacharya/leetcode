
public class BestTimeToBuyAndSellStocks {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (i == j) {
                    continue;
                }
                max = max < prices[j] - prices[i] ? prices[j] - prices[i] : max;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        BestTimeToBuyAndSellStocks bttbass = new BestTimeToBuyAndSellStocks();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bttbass.maxProfit(prices));
    }
}
