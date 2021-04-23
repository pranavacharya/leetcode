
import java.util.Arrays;

public class PartitionArrayforMaximumSum {

    private int[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.dp = new int[arr.length + 1];
        Arrays.fill(this.dp, -1);
        return helper(0, arr, k);
    }

    private int helper(int i, int[] arr, int min) {
        if (this.dp[i] != -1) {
            return this.dp[i];
        }
        int max = 0;
        int maxElement = 0;
        for (int k = i; k < Math.min(arr.length, i + min); k++) {
            maxElement = Math.max(maxElement, arr[k]);
            max = Math.max(max, maxElement * (k - i + 1) + helper(k + 1, arr, min));
        }
        return this.dp[i] = max;
    }

    public static void main(String[] args) {
        PartitionArrayforMaximumSum pams = new PartitionArrayforMaximumSum();
        int[] arr = new int[]{1, 15, 7, 9, 2, 5, 10};
        System.out.println(pams.maxSumAfterPartitioning(arr, 3));
    }
}
