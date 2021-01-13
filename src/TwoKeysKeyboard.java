
public class TwoKeysKeyboard {

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        TwoKeysKeyboard tkk = new TwoKeysKeyboard();
        System.out.println(tkk.minSteps(15));
    }
}
