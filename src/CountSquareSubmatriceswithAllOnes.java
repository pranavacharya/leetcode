
public class CountSquareSubmatriceswithAllOnes {

    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        CountSquareSubmatriceswithAllOnes csswalo = new CountSquareSubmatriceswithAllOnes();
        int[][] matrix = new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(csswalo.countSquares(matrix));
    }
}
