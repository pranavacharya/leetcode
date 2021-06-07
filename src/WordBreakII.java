
import java.util.ArrayList;
import java.util.List;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList();
        helper(0, wordDict, s, "", ans);
        return ans;
    }

    private void helper(int index, List<String> wordDict, String s, String sentence, List<String> result) {
        if (index == s.length()) {
            result.add(new String(sentence).trim());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (wordDict.contains(s.substring(index, i + 1))) {
                String path = sentence + (s.substring(index, i + 1) + " ");
                helper(i + 1, wordDict, s, path, result);
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII wb2 = new WordBreakII();
        List<String> wordDict = new ArrayList();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(wb2.wordBreak("catsanddog", wordDict));
    }
}
