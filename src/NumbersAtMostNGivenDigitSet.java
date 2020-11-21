
public class NumbersAtMostNGivenDigitSet {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String nString = String.valueOf(n);
        int nLength = nString.length();
        int[] dp = new int[nLength + 1];
        dp[nLength] = 1;

        for (int i = nLength - 1; i >= 0; --i) {
            int Si = nString.charAt(i) - '0';
            for (String digit : digits) {
                if (Integer.valueOf(digit) < Si) {
                    dp[i] += Math.pow(digits.length, nLength - i - 1);
                } else if (Integer.valueOf(digit) == Si) {
                    dp[i] += dp[i + 1];
                }
            }
        }

        for (int i = 1; i < nLength; ++i) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }

    public static void main(String args[]) {
        NumbersAtMostNGivenDigitSet nmngds = new NumbersAtMostNGivenDigitSet();
        String[] digits = new String[]{"3", "4", "8"};
        System.out.println(nmngds.atMostNGivenDigitSet(digits, 4));
    }
}
