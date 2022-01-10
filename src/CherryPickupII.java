
import java.util.Arrays;

public class CherryPickupII {

    private int[][][] dp;

    public int cherryPickup(int[][] grid) {
        this.dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(this.dp[i][j], -1);
            }
        }
        return helper(grid, 0, 0, grid[0].length - 1);
    }

    private int helper(int[][] grid, int i, int j1, int j2) {
        if (j1 < 0 || j1 > grid[0].length - 1 || j2 < 0 || j2 > grid[0].length - 1) {
            return Integer.MIN_VALUE;
        }

        if (i == grid.length) {
            return 0;
        }

        if (this.dp[i][j1][j2] != -1) {
            return this.dp[i][j1][j2];
        }

        int cherries = 0;
        if (j1 == j2) {
            cherries += grid[i][j1];
        } else {
            cherries += grid[i][j1];
            cherries += grid[i][j2];
        }

        int f1 = helper(grid, i + 1, j1 - 1, j2);
        int f2 = helper(grid, i + 1, j1, j2);
        int f3 = helper(grid, i + 1, j1 + 1, j2);
        int f4 = helper(grid, i + 1, j1 - 1, j2 - 1);
        int f5 = helper(grid, i + 1, j1, j2 - 1);
        int f6 = helper(grid, i + 1, j1 + 1, j2 - 1);
        int f7 = helper(grid, i + 1, j1 - 1, j2 + 1);
        int f8 = helper(grid, i + 1, j1, j2 + 1);
        int f9 = helper(grid, i + 1, j1 + 1, j2 + 1);

        int max = Math.max(Math.max(Math.max(Math.max(f1, f2), Math.max(f3, f4)), Math.max(Math.max(f5, f6), Math.max(f7, f8))), f9);

        cherries += max;

        return this.dp[i][j1][j2] = cherries;
    }

    public static void main(String[] args) {
        CherryPickupII cp = new CherryPickupII();
        int[][] grid = new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        System.out.println(cp.cherryPickup(grid));
    }
}
