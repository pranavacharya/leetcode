
public class MaximizePalindromeLengthFromSubsequences {

    public void longestPalindromeSubseq(String s, int[][] dp) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            dp[i][i] = 1;
        }
        for (int l = 2; l <= str.length; l++) {
            for (int i = 0; i < str.length - l + 1; i++) {
                int j = i + l - 1;
                if (l == 2 && str[i] == str[j]) {
                    dp[i][j] = 2;
                } else if (str[i] == str[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
    }

    public int longestPalindrome(String word1, String word2) {
        String word = word1 + word2;
        int[][] dp = new int[word.length()][word.length()];
        longestPalindromeSubseq(word, dp);
        int max = 0;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) != word2.charAt(j)) {
                    continue;
                } else {
                    max = Math.max(max, dp[i][word1.length() + j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximizePalindromeLengthFromSubsequences mplfs
                = new MaximizePalindromeLengthFromSubsequences();
        System.out.println(mplfs.longestPalindrome("cacb", "cbba"));
    }
}
