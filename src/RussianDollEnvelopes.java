
import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? Double.compare(a[1], b[1]) : Double.compare(a[0], b[0]));
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes rde = new RussianDollEnvelopes();
        int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(rde.maxEnvelopes(envelopes));
    }
}
