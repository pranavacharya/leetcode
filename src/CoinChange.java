
import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i + 1][j] = 0;
                    continue;
                }
                if (j < coins[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    if (dp[i + 1][j - coins[i]] == Integer.MAX_VALUE) {
                        dp[i + 1][j] = dp[i][j];        
                    } else {
                        dp[i + 1][j] = Math.min(dp[i][j], 1 + dp[i + 1][j - coins[i]]);    
                    }
                }                    
            }
        }  
        return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    }

    public static void main(String args[]) {
        CoinChange cc = new CoinChange();
        int[] coins = new int[]{1, 2, 5};
        System.out.println(cc.coinChange(coins, 11));
    }
}
