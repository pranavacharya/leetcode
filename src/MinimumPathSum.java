
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] dp = grid;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i != 0 && j != 0) {
                    dp[i][j] += +Math.min(dp[i][j - 1], dp[i - 1][j]);
                } else if (i == 0 && j != 0) {
                    dp[i][j] += dp[i][j - 1];
                } else if (j == 0 && i != 0) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[dp.length - 1].length - 1];
    }

    public static void main(String args[]) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(mps.minPathSum(grid));
    }
}
