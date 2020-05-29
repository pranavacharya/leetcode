
import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + 1;
            }
        }
        return dp;
    }

    public static void main(String args[]) {
        CountingBits cb = new CountingBits();
        System.out.println(Arrays.toString(cb.countBits(16)));
    }
}
