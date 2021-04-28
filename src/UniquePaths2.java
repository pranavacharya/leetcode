
import java.util.Arrays;

public class UniquePaths2 {

    private int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        this.dp = new int[n][m];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(obstacleGrid, n - 1, m - 1);
    }

    private int helper(int[][] obstacleGrid, int i, int j) {
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        int ans = 0;

        if (i > 0) {
            ans += helper(obstacleGrid, i - 1, j);
        }

        if (j > 0) {
            ans += helper(obstacleGrid, i, j - 1);
        }

        return this.dp[i][j] = ans;
    }

    public static void main(String args[]) {
        UniquePaths2 up2 = new UniquePaths2();
        int[][] obstacleGrid = new int[][]{{0}};
        System.out.println(up2.uniquePathsWithObstacles(obstacleGrid));
    }
}
