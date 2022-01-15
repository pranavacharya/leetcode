
import java.util.Arrays;

public class LongestIncreasingPathinaMatrix {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.dp = new int[n][m];

        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int local = helper(matrix, i, j);
                ans = Math.max(ans, local);
            }
        }

        return ans;
    }

    private int helper(int[][] matrix, int i, int j) {

        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        int ans = 0;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[x].length - 1) {
                continue;
            }

            if (matrix[i][j] < matrix[x][y]) {
                ans = Math.max(ans, helper(matrix, x, y));
            }
        }

        return this.dp[i][j] = ans + 1;
    }

    public static void main(String[] args) {
        LongestIncreasingPathinaMatrix lipm = new LongestIncreasingPathinaMatrix();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(lipm.longestIncreasingPath(matrix));
    }
}
