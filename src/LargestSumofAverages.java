
import java.util.Arrays;

public class LargestSumofAverages {

    private double[][] dp;

    public double largestSumOfAverages(int[] A, int K) {
        this.dp = new double[A.length][K + 1];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1.0);
        }
        double[] prefix = new double[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }
        return helper(0, A.length, K, prefix);
    }

    private double helper(int i, int len, int k, double[] prefix) {

        if (this.dp[i][k] != -1) {
            return this.dp[i][k];
        }

        if (k == 1) {
            return this.dp[i][k] = ((double) (prefix[len] - prefix[i]) / (len - i));
        }

        double max = 0;

        for (int l = i; l + k <= len; l++) {
            max = Math.max(max, ((double) (prefix[l + 1] - prefix[i]) / (l - i + 1)) + helper(l + 1, len, k - 1, prefix));
        }
        return this.dp[i][k] = max;
    }

    public static void main(String[] args) {
        LargestSumofAverages lsa = new LargestSumofAverages();
        int[] A = new int[]{9, 1, 2, 3, 9};
        System.out.println(lsa.largestSumOfAverages(A, 3));
    }
}
