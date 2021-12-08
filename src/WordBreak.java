
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    private int[][] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(this.dp[i], -1);
        }
        HashSet<String> set = new HashSet();
        set.addAll(wordDict);
        return helper(s, set, 0, s.length()) == 1;
    }

    private int helper(String s, HashSet<String> set, int i, int j) {
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        if (set.contains(s.substring(i, j))) {
            return dp[i][j] = 1;
        }

        for (int k = i + 1; k < j; k++) {
            if (helper(s, set, i, k) == 1 && helper(s, set, k, j) == 1) {
                return dp[i][j] = 1;
            }
        }

        return dp[i][j] = 0;
    }

    public static void main(String args[]) {
        WordBreak wb = new WordBreak();
        ArrayList<String> wd = new ArrayList<>();
        wd.add("cats");
        wd.add("dog");
        wd.add("sand");
        wd.add("and");
        wd.add("cat");
        System.out.println(wb.wordBreak("catsandog", wd));
    }
}
