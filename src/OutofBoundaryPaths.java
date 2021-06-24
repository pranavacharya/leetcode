
import java.util.Arrays;

public class OutofBoundaryPaths {

    private int mod = (int) 1e9 + 7;

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < this.dp.length; i++) {
            for (int j = 0; j < this.dp[i].length; j++) {
                Arrays.fill(this.dp[i][j], -1);
            }
        }

        return helper(m, n, startRow, startColumn, maxMove);
    }

    private int helper(int m, int n, int i, int j, int moves) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return 1;
        }

        if (this.dp[i][j][moves] != -1) {
            return this.dp[i][j][moves];
        }

        int paths = 0;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (moves > 0) {
                paths = (paths % mod + helper(m, n, x, y, moves - 1) % mod) % mod;
            }
        }

        return this.dp[i][j][moves] = paths;
    }

    public static void main(String[] args) {
        OutofBoundaryPaths oobp = new OutofBoundaryPaths();
        System.out.println(oobp.findPaths(2, 2, 2, 0, 0));
    }
}
