
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    private int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.dp = new int[s.length()];
        Arrays.fill(this.dp, -1);
        return helper(0, wordDict, s);
    }

    private boolean helper(int index, List<String> dict, String s) {
        if (index == s.length()) {
            return true;
        }
        if (this.dp[index] != -1) {
            return this.dp[index] == 1;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(index, i)) && helper(i, dict, s)) {
                this.dp[index] = 1;
                return true;
            }
        }
        this.dp[index] = 0;
        return false;
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
