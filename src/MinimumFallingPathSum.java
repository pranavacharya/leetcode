
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length][A[0].length];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = A[i][j];
                } else {
                    int top = dp[i - 1][j];
                    int topleft = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                    int topright = j == dp[0].length - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1];
                    int value = Math.min(Math.min(top, topleft), topright);
                    dp[i][j] = value + A[i][j];
                }
                if (i == dp.length - 1) {
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        MinimumFallingPathSum mfps = new MinimumFallingPathSum();
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(mfps.minFallingPathSum(A));
    }
}
