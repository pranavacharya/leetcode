
import java.util.Arrays;

public class BestSightseeingPair {

    int[][] dp;

    public int maxScoreSightseeingPair(int[] values) {
        this.dp = new int[values.length][values.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, values.length - 1, values);
    }

    private int helper(int i, int j, int[] values) {
        if (i == j) {
            return 0;
        }

        if (this.dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = values[i] + values[j] + i - j;

        for (int k = i + 1; k < j; k++) {
            max = Math.max(max, Math.max(helper(i, k, values), helper(k, j, values)));
        }
        // System.out.println("i " + i + " j " + j + " max " + max);
        return dp[i][j] = max;
    }

    public static void main(String[] args) {
        BestSightseeingPair bsp = new BestSightseeingPair();
        int[] values = new int[]{8, 1, 5, 2, 6};
        System.out.println(bsp.maxScoreSightseeingPair(values));
    }
}
