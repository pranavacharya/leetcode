
import java.util.Arrays;

public class StoneGameII {

    private int[][] dp;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        this.dp = new int[n][n];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        int[] suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        return dfs(0, 1, suffix);
    }

    private int dfs(int index, int m, int[] suffix) {
        if (index >= suffix.length) {
            return 0;
        }

        if (2 * m >= suffix.length - index) {
            return suffix[index];
        }

        if (this.dp[index][m] != - 1) {
            return this.dp[index][m];
        }

        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= (2 * m); x++) {
            min = Math.min(min, dfs(index + x, Math.max(x, m), suffix));
        }
        return this.dp[index][m] = suffix[index] - min;
    }

    public static void main(String[] args) {
        StoneGameII sg = new StoneGameII();
        int[] piles = new int[]{1};
        System.out.println(sg.stoneGameII(piles));
    }
}
