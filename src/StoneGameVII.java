
import java.util.Arrays;

public class StoneGameVII {

    private int[][] dp;

    public int stoneGameVII(int[] stones) {
        this.dp = new int[stones.length][stones.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        int[] prefix = new int[stones.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = stones[i - 1] + prefix[i - 1];
        }
        return helper(stones, 0, stones.length - 1, prefix);
    }

    private int helper(int[] stones, int i, int j, int[] prefix) {
        if (i == j) {
            return 0;
        }
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }
        int max = 0;
        max = Math.max(prefix[j + 1] - prefix[i + 1] - helper(stones, i + 1, j, prefix),
                prefix[j] - prefix[i] - helper(stones, i, j - 1, prefix));
        return this.dp[i][j] = max;
    }

    public static void main(String args[]) {
        StoneGameVII sg = new StoneGameVII();
        int[] stones = new int[]{5, 3, 1, 4, 2};
        System.out.println(sg.stoneGameVII(stones));
    }
}
