
public class TwoKeysKeyboard {

    public int minSteps(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 2;
            } else {
                boolean prime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + (i / j);
                        prime = false;
                    }
                }
                if (prime) {
                    dp[i] = i;
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
