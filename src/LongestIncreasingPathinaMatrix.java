
import java.util.Arrays;

public class LongestIncreasingPathinaMatrix {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        this.dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int longestPath = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j));
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int pathLength = 1;
        int maxLength = 0;
        for (int[] dir : dirs) {
            if (row + dir[0] >= 0 && row + dir[0] < matrix.length && col + dir[1] >= 0
                    && col + dir[1] < matrix[0].length
                    && matrix[row + dir[0]][col + dir[1]] > matrix[row][col]) {
                maxLength = Math.max(maxLength, dfs(matrix, row + dir[0], col + dir[1]));
            }
        }
        this.dp[row][col] = pathLength + maxLength;
        return this.dp[row][col];
    }

    public static void main(String[] args) {
        LongestIncreasingPathinaMatrix lipm = new LongestIncreasingPathinaMatrix();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(lipm.longestIncreasingPath(matrix));
    }
}
