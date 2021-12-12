
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[2][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            dp[0][i] = matrix[0][i];
            min = Math.min(min, dp[0][i]);
        }
        int last = 0;
        for (int i = 1; i < matrix.length; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                dp[(last + 1) % 2][j] = dp[last][j];

                if (j != 0) {
                    dp[(last + 1) % 2][j] = Math.min(dp[last][j - 1], dp[(last + 1) % 2][j]);
                }

                if (j != matrix[i].length - 1) {
                    dp[(last + 1) % 2][j] = Math.min(dp[last][j + 1], dp[(last + 1) % 2][j]);
                }
                dp[(last + 1) % 2][j] += matrix[i][j];
                min = Math.min(min, dp[(last + 1) % 2][j]);
            }
            last++;
            last %= 2;
        }
        return min;
    }

    public static void main(String args[]) {
        MinimumFallingPathSum mfps = new MinimumFallingPathSum();
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(mfps.minFallingPathSum(A));
    }
}
