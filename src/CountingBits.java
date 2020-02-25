
import java.util.Arrays;


public class CountingBits {

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            int c = 1;
            while (c * 2 <= i) {
                c = c * 2;
            }
            dp[i] = 1 + dp[i - c];
        }
        return dp;
    }

    public static void main(String args[]) {
        CountingBits cb = new CountingBits();
        System.out.println(Arrays.toString(cb.countBits(5)));
    }
}
