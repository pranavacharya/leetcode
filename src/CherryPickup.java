
import java.util.Arrays;

public class CherryPickup {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i + 1][j + 1] = 1;
                }
                if (grid[i][j] == -1) {
                    continue;
                }
                if ((i != 0 && j != 0) && grid[i - 1][j] == -1 && grid[i][j - 1] == 0) {
                    dp[i + 1][j + 1] = 0;
                }
                dp[i + 1][j + 1] += Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        count += dp[n][m];

        if (dp[n][m] == 0) {
            return 0;
        }
        resetGrid(grid, dp, n, m);

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i + 1][j + 1] = 1;
                }
                if (grid[i][j] == -1) {
                    continue;
                }
                if ((i != 0 && j != 0) && grid[i - 1][j] == -1 && grid[i][j - 1] == 0) {
                    dp[i + 1][j + 1] = 0;
                }
                dp[i + 1][j + 1] += Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        count += dp[n][m];

        return count;
    }

    private void resetGrid(int[][] grid, int[][] dp, int n, int m) {
        int i = n;
        int j = m;

        while (i > 1 && j > 1) {
            if (grid[i - 1][j - 1] == 1) {
                dp[i][j]--;
            }
            grid[i - 1][j - 1] = 0;
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }

        while (i > 1) {
            grid[i - 1][j - 1] = 0;
            i--;
        }

        while (j > 1) {
            grid[i - 1][j - 1] = 0;
            j--;
        }

        grid[i - 1][j - 1] = 0;

    }

    public static void main(String[] args) {
        CherryPickup cp = new CherryPickup();
        int[][] grid = new int[][]{
            {1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1}};
//        int[][] grid = new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}};
//        int[][] grid = new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        System.out.println(cp.cherryPickup(grid));
    }
}
