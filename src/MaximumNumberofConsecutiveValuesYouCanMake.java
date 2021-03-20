
import java.util.Arrays;

public class MaximumNumberofConsecutiveValuesYouCanMake {

    public int getMaximumConsecutive(int[] coins) {
        int n = coins.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += coins[i];
        }
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i - 1][j - coins[i - 1]];
                }
            }
        }
        int[] valid = dp[n];
        System.out.println(Arrays.toString(valid));
        int ans = 0;
        int count = 0;
        for (int i = 0; i < valid.length; i++) {
            if (valid[i] != 0) {
                count++;
            } else {
                count = 0;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumNumberofConsecutiveValuesYouCanMake mncvym = new MaximumNumberofConsecutiveValuesYouCanMake();
        int[] coins = new int[]{1, 4, 10, 3, 1};
        System.out.println(mncvym.getMaximumConsecutive(coins));
    }
}
//[[1, 0, 0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1, 1, 1], [1, 2, 3, 4, 5, 6, 7, 8], [1, 3, 6, 10, 15, 21, 28, 36], [0, 3, 6, 10, 15, 24, 34, 46]]
//46
