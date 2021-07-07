
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        char[] arr = s.toCharArray();
        if (arr[0] != '0') {
            dp[1] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            int digit = arr[i] - '0';
            int prev = arr[i - 1] - '0';
            prev *= 10;
            prev += digit;
            if (digit >= 1 && digit <= 9) {
                dp[i + 1] += dp[i];
            }
            if (prev >= 10 && prev <= 26) {
                dp[i + 1] += dp[i - 1];
            }

        }
        return dp[arr.length];
    }

    public static void main(String args[]) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("22"));
    }
}
