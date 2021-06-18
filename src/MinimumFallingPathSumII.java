
import java.util.Arrays;

public class MinimumFallingPathSumII {

    private int[][] dp;

    public int minFallingPathSum(int[][] arr) {
        this.dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < arr.length; j++) {
            ans = Math.min(ans, helper(arr, 0, j));
        }
        return ans;
    }

    private int helper(int[][] arr, int row, int col) {
        if (row == arr.length) {
            return 0;
        }
        if (this.dp[row][col] != -1) {
            return this.dp[row][col];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < arr.length; j++) {
            if (j == col) {
                continue;
            } else {
                ans = Math.min(ans, helper(arr, row + 1, j));
            }
        }
        return this.dp[row][col] = ans + arr[row][col];
    }

    public static void main(String[] args) {
        MinimumFallingPathSumII mfps = new MinimumFallingPathSumII();
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(mfps.minFallingPathSum(arr));
    }
}
