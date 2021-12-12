
public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                dp[i + 1] = 0;
            } else {
                dp[i + 1] = dp[i];
            }
            if (i > 0 && s.charAt(i) >= '0' && s.charAt(i) <= '6'
                    && s.charAt(i - 1) == '2') {
                dp[i + 1] += dp[i - 1];
            } else if (i > 0 && s.charAt(i) >= '0' && s.charAt(i) <= '9'
                    && s.charAt(i - 1) == '1') {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String args[]) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("22"));
    }
}
