
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindandReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if (isMatching(words[i], pattern)) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private boolean isMatching(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        HashMap<Character, Character> wordMap = new HashMap();
        HashMap<Character, Character> patternMap = new HashMap();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            char p = pattern.charAt(i);
            if (wordMap.containsKey(c)) {
                if (wordMap.get(c) == p) {
                    if (patternMap.get(p) != c) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (patternMap.containsKey(p)) {
                    return false;
                }
                wordMap.put(c, p);
                patternMap.put(p, c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindandReplacePattern frp = new FindandReplacePattern();
        String[] words = new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        System.out.println(frp.findAndReplacePattern(words, "abb"));
    }
}
