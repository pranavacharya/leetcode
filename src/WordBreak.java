
import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
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
