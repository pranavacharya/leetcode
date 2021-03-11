
import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    public static void main(String args[]) {
        CoinChange cc = new CoinChange();
        int[] coins = new int[]{1, 2, 5};
        System.out.println(cc.coinChange(coins, 11));
    }
}
