
import java.util.Arrays;

public class LongestPalindromicSubsequence {

    private int[][] dp;

    public int longestPalindromeSubseq(String s) {
        this.dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(0, s.length() - 1, s);
    }

    private int helper(int i, int j, String s) {

        if (i > j) {
            return 0;
        }

        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        if (i == j) {
            return this.dp[i][j] = 1;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return this.dp[i][j] = (2 + helper(i + 1, j - 1, s));
        }

        int max = 0;

        max = Math.max(helper(i + 1, j, s), helper(i, j - 1, s));

        return this.dp[i][j] = max;
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.longestPalindromeSubseq("bbbab"));
        System.out.println(lps.longestPalindromeSubseq("cbbd"));
    }
}
