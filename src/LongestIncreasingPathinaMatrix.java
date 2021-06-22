
import java.util.Arrays;

public class LongestIncreasingPathinaMatrix {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int longestPathSize = 0;
        this.dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                longestPathSize = Math.max(longestPathSize, helper(matrix, i, j));
            }
        }
        return longestPathSize;
    }

    private int helper(int[][] matrix, int i, int j) {
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        int ans = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[i].length && matrix[x][y] > matrix[i][j]) {
                ans = Math.max(ans, 1 + helper(matrix, x, y));
            }
        }
        return this.dp[i][j] = ans;
    }

    public static void main(String[] args) {
        LongestIncreasingPathinaMatrix lipm = new LongestIncreasingPathinaMatrix();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(lipm.longestIncreasingPath(matrix));
    }
}
