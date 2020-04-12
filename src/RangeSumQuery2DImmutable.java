
public class RangeSumQuery2DImmutable {

    private int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length != 0) {
            this.dp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + matrix[i][j];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            int min = (col1 - 1) < 0 ? 0 : dp[i][col1 - 1];
            sum += (dp[i][col2] - min);
        }
        return sum;
    }

    public static void main(String args[]) {
        int[][] matrix = new int[][]{{-1}};
        RangeSumQuery2DImmutable rsq = new RangeSumQuery2DImmutable(matrix);
        System.out.println(rsq.sumRegion(0, 0, 0, 0));
    }
}
