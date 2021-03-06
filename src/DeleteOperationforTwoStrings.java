
public class DeleteOperationforTwoStrings {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[word1.length()][word2.length()];
        return word1.length() - lcs + word2.length() - lcs;
    }

    public static void main(String[] args) {
        DeleteOperationforTwoStrings dots = new DeleteOperationforTwoStrings();
        System.out.println(dots.minDistance("sea", "eat"));
    }
}
