
import java.util.Arrays;

public class FinalPricesWithaSpecialDiscountinaShop {

    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int low = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    low = prices[j];
                    break;
                }
            }
            ans[i] = prices[i] - low;
        }
        return ans;
    }

    public static void main(String args[]) {
        FinalPricesWithaSpecialDiscountinaShop fpsd = new FinalPricesWithaSpecialDiscountinaShop();
        int[] prices = new int[]{8, 4, 6, 2, 3};
        System.out.println(Arrays.toString(fpsd.finalPrices(prices)));
    }
}
