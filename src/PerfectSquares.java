
import java.util.Arrays;

public class PerfectSquares {

    public int numSquares(int n) {
        if (n < 4) {
            return n;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(13));
    }
}
