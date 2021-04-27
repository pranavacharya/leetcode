
import java.util.Arrays;

public class MinimumPathSum {

    private int[][] dp;

    public int minPathSum(int[][] grid) {
        this.dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(grid.length - 1, grid[0].length - 1, grid);
    }

    private int helper(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        if (i > 0) {
            ans = Math.min(ans, helper(i - 1, j, grid));
        }
        if (j > 0) {
            ans = Math.min(ans, helper(i, j - 1, grid));
        }
        return this.dp[i][j] = ans + grid[i][j];
    }

    public static void main(String args[]) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(mps.minPathSum(grid));
    }
}
