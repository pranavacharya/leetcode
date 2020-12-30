
import java.util.Arrays;

public class MaximumLengthofPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Double.compare(a[0], b[0]));
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < pairs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumLengthofPairChain mlofc = new MaximumLengthofPairChain();
        int[][] pairs = new int[][]{{1, 2}, {7, 8}, {3, 4}, {5, 6}};
        System.out.println(mlofc.findLongestChain(pairs));
    }
}
