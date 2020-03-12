
public class BestTimeToButAndSellStock2 {

    public int maxProfit(int[] prices) {
        int max = 0;
        int i;
        int j;
        for (i = 0, j = 0; i < prices.length; i++) {
            if (i > 0) {
                if (prices[i - 1] > prices[i]) {
                    if ((prices[i - 1] - prices[j]) > 0) {
                        max += (prices[i - 1] - prices[j]);
                    }
                    j = i;
                }
            }
        }
        if (j != i) {
            max += (prices[i - 1] - prices[j]);
        }
        return max;
    }

    public static void main(String args[]) {
        BestTimeToButAndSellStock2 bttbass2 = new BestTimeToButAndSellStock2();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bttbass2.maxProfit(prices));
    }
}
