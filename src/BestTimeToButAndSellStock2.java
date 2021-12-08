
public class BestTimeToButAndSellStock2 {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                profit += prices[i] - min;
                min = prices[i];
            } else {
                min = prices[i];
            }
        }
        return profit;
    }

    public static void main(String args[]) {
        BestTimeToButAndSellStock2 bttbass2 = new BestTimeToButAndSellStock2();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bttbass2.maxProfit(prices));
    }
}
