
import java.util.Arrays;

public class OnesandZeroes {

    int[][][] dp;

    public int findMaxForm(String[] strs, int m, int n) {

        int[] ones = new int[strs.length];
        int[] zeros = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int count = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '1') {
                    count++;
                }
            }
            ones[i] = count;
            zeros[i] = strs[i].length() - count;
        }

        this.dp = new int[m + 1][n + 1][strs.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(ones, zeros, m, n, 0);

    }

    private int helper(int[] ones, int[] zeros, int m, int n, int index) {
        if (index >= ones.length) {
            return 0;
        }

        if (this.dp[m][n][index] != -1) {
            return this.dp[m][n][index];
        }

        int ans = 0;

        // take
        if (m - zeros[index] >= 0 && n - ones[index] >= 0) {
            ans = Math.max(ans, 1 + helper(ones, zeros, m - zeros[index], n - ones[index], index + 1));
        }

        // dont take
        ans = Math.max(ans, helper(ones, zeros, m, n, index + 1));

        return this.dp[m][n][index] = ans;
    }

    public static void main(String[] args) {
        OnesandZeroes oz = new OnesandZeroes();
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(oz.findMaxForm(strs, 5, 3));
    }
}
