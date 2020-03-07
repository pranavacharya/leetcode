
public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (Integer.valueOf(s.substring(i - 1, i)) >= 1) {
                dp[i] += dp[i - 1];
            }
            if (Integer.valueOf(s.substring(i - 2, i)) <= 26 && Integer.valueOf(s.substring(i - 2, i)) >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String args[]) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("226"));
    }
}
