
import java.util.Arrays;

public class PartitionArrayforMaximumSum {

    private int[][] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.dp = new int[arr.length][arr.length];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(0, arr.length - 1, arr, k);
    }

    private int helper(int i, int j, int[] arr, int min) {
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        if (i == j) {
            return this.dp[i][j] = arr[i];
        }

        if (j - i + 1 <= min) {
            int max = 0;
            for (int k = i; k <= j; k++) {
                max = Math.max(max, arr[k]);
            }
            return this.dp[i][j] = max * (j - i + 1);
        }

        int max = 0;

        for (int k = i; k < j; k++) {
            max = Math.max(max, helper(i, k, arr, min) + helper(k + 1, j, arr, min));
        }

        return this.dp[i][j] = max;
    }

    public static void main(String[] args) {
        PartitionArrayforMaximumSum pams = new PartitionArrayforMaximumSum();
        int[] arr = new int[]{1, 15, 7, 9, 2, 5, 10};
        System.out.println(pams.maxSumAfterPartitioning(arr, 3));
    }
}
