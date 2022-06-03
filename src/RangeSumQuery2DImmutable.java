
import java.util.Arrays;

public class RangeSumQuery2DImmutable {

    private int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                    continue;
                }
                dp[i][j] = matrix[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(this.dp));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = dp[row2][col2];
        if (row1 > 0 && col1 > 0) {
            ans += dp[row1 - 1][col1 - 1];
        }
        if (row1 > 0) {
            ans -= dp[row1 - 1][col2];
        }
        if (col1 > 0) {
            ans -= dp[row2][col1 - 1];
        }
        return ans;
    }

    public static void main(String args[]) {
        int[][] matrix = new int[][]{{-1}};
        RangeSumQuery2DImmutable rsq = new RangeSumQuery2DImmutable(matrix);
        System.out.println(rsq.sumRegion(0, 0, 0, 0));
    }
}
