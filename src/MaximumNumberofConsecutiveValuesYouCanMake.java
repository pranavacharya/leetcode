
import java.util.Arrays;

public class MaximumNumberofConsecutiveValuesYouCanMake {

    public int getMaximumConsecutive(int[] coins) {
        int ans = 0;
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > ans + 1) {
                break;
            } else {
                ans += coins[i];
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        MaximumNumberofConsecutiveValuesYouCanMake mncvym = new MaximumNumberofConsecutiveValuesYouCanMake();
        int[] coins = new int[]{1, 3};
        System.out.println(mncvym.getMaximumConsecutive(coins));
    }
}
//[[1, 0, 0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1, 1, 1], [1, 2, 3, 4, 5, 6, 7, 8], [1, 3, 6, 10, 15, 21, 28, 36], [0, 3, 6, 10, 15, 24, 34, 46]]
//46
