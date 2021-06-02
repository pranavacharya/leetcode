
import java.util.Arrays;

public class InterleavingString {

    private int dp[][];

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        this.dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(0, 0, 0, s1, s2, s3) == 1;
    }

    private int helper(int i, int j, int k, String s1, String s2, String s3) {
        if (k == s3.length()) {
            return 1;
        }
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }
        if (i < s1.length() && j < s2.length()
                && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
            return this.dp[i][j] = (helper(i + 1, j, k + 1, s1, s2, s3) == 1
                    || helper(i, j + 1, k + 1, s1, s2, s3) == 1) ? 1 : 0;
        } else if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {

            return this.dp[i][j] = (helper(i + 1, j, k + 1, s1, s2, s3) == 1) ? 1 : 0;
        } else if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            return this.dp[i][j] = (helper(i, j + 1, k + 1, s1, s2, s3) == 1) ? 1 : 0;
        } else {
            return this.dp[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
