
import java.util.Arrays;

public class LargestSumofAverages {

    private double[][][] dp;

    public double largestSumOfAverages(int[] A, int K) {
        this.dp = new double[A.length][A.length][K];
        for (int i = 0; i < this.dp.length; i++) {
            for (int j = 0; j < this.dp[i].length; j++) {
                Arrays.fill(this.dp[i][j], -1.0);
            }
        }
        double[] prefix = new double[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }
        return helper(0, A.length - 1, K - 1, prefix);
    }

    private double helper(int i, int j, int k, double[] prefix) {

        if (this.dp[i][j][k] != -1) {
            return this.dp[i][j][k];
        }

        if (i == j || k == 0) {
            return this.dp[i][j][k] = (double) (prefix[j + 1] - prefix[i]) / (double) (j - i + 1);
        }

        double max = 0;

        // X
        for (int l = i; l < j; l++) {
            // K
            for (int m = 0; m < k; m++) {
                max = Math.max(max, helper(i, l, m, prefix) + helper(l + 1, j, k - 1 - m, prefix));
            }
        }
        return this.dp[i][j][k] = max;
    }

    public static void main(String[] args) {
        LargestSumofAverages lsa = new LargestSumofAverages();
        int[] A = new int[]{9, 1, 2, 3, 9};
        System.out.println(lsa.largestSumOfAverages(A, 3));
    }
}
