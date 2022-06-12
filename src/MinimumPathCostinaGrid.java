
import java.util.Arrays;

public class MinimumPathCostinaGrid {

    private int[][] dp;

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int min = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        this.dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, helper(grid, 0, i, moveCost));
        }
        return min;
    }

    private int helper(int[][] grid, int i, int j, int[][] moveCost) {
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        if (i == grid.length - 1) {
            return this.dp[i][j] = grid[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int a = 0; a < grid[0].length; a++) {
            ans = Math.min(ans, grid[i][j] + moveCost[grid[i][j]][a] + helper(grid, i + 1, a, moveCost));
        }

        return this.dp[i][j] = ans;
    }

    public static void main(String[] args) {
        MinimumPathCostinaGrid mpcg = new MinimumPathCostinaGrid();
        int[][] grid = new int[][]{{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost = new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        System.out.println(mpcg.minPathCost(grid, moveCost));
    }
}
