
import java.util.Arrays;

public class MaximumLengthofPairChain {

    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> Double.compare(a[0], b[0]));
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                int value = pairs[j][1] < pairs[i][0] ? 1 : 0;
                dp[i] = Math.max(dp[i], dp[j] + value);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String args[]) {
        MaximumLengthofPairChain mlofc = new MaximumLengthofPairChain();
        int[][] pairs = new int[][]{{1, 2}, {7, 8}, {3, 4}, {5, 6}};
        System.out.println(mlofc.findLongestChain(pairs));
    }
}
