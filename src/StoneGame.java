
import java.util.Arrays;

public class StoneGame {

    private int[][] dp;

    public boolean stoneGame(int[] piles) {
        this.dp = new int[piles.length][piles.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return dfs(0, piles.length - 1, piles) > 0;
    }

    private int dfs(int i, int j, int[] piles) {
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }
        if (i == j) {
            return this.dp[i][j] = piles[i];
        }
        return this.dp[i][j] = Math.max(piles[i] - dfs(i + 1, j, piles), piles[j] - dfs(i, j - 1, piles));
    }

    public static void main(String args[]) {
        StoneGame sg = new StoneGame();
        int[] piles = new int[]{5, 3, 4, 5};
        System.out.println(sg.stoneGame(piles));
    }
}
