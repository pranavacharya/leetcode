
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    max = Math.max(max, dp[i][j]);
                } else if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    if (i - 1 >= 0) {
                        min = Math.min(min, dp[i - 1][j]);
                    }
                    if (j - 1 >= 0) {
                        min = Math.min(min, dp[i][j - 1]);
                    }
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        min = Math.min(min, dp[i - 1][j - 1]);
                    }
                    min = min == Integer.MAX_VALUE ? 0 : min;
                    dp[i][j] = min + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String args[]) {
        MaximalSquare ms = new MaximalSquare();
//        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
//        {'1', '1', '1', '1', '1'}, {'1', '0', '1', '1', '1'}};
        char[][] matrix = new char[][]{
            {'1', '1', '1', '1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1', '1', '1', '0'},
            {'1', '1', '1', '1', '1', '1', '1', '0'},
            {'1', '1', '1', '1', '1', '0', '0', '0'},
            {'0', '1', '1', '1', '1', '0', '0', '0'}
        };
        System.out.println(ms.maximalSquare(matrix));
    }
}
