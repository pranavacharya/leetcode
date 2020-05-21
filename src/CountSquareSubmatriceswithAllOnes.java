
public class CountSquareSubmatriceswithAllOnes {

    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int top = 0;
                    int left = 0;
                    int topleft = 0;
                    if (i > 0) {
                        top = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    if (i > 0 && j > 0) {
                        topleft = dp[i - 1][j - 1];
                    }
                    dp[i][j] = Math.min(Math.min(top, left), topleft) + 1;
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
