
import java.util.Arrays;

public class LongestIncreasingPathinaMatrix {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;

        this.dp = new int[matrix.length][matrix[0].length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans = Math.max(ans, helper(matrix, i, j));
            }
        }

        return ans;
    }

    private int helper(int[][] matrix, int i, int j) {

        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        int max = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                max = Math.max(max, helper(matrix, x, y));
            }

        }
        return dp[i][j] = max + 1;
    }

    public static void main(String[] args) {
        LongestIncreasingPathinaMatrix lipm = new LongestIncreasingPathinaMatrix();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(lipm.longestIncreasingPath(matrix));
    }
}
