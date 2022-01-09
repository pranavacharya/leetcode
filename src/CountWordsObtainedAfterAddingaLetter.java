
import java.util.Arrays;

public class CountWordsObtainedAfterAddingaLetter {

    class Trie {

        Trie[] children = new Trie[26];
        boolean isEnd = false;
    }

    private void BuildTrie(String word, Trie root) {
        Trie temp = root;
        char[] sorted = word.toCharArray();
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; i++) {
            if (temp.children[sorted[i] - 'a'] == null) {
                temp.children[sorted[i] - 'a'] = new Trie();
            }
            temp = temp.children[sorted[i] - 'a'];
        }
        temp.isEnd = true;
    }

    public int wordCount(String[] startWords, String[] targetWords) {
        Trie root = new Trie();
        for (int i = 0; i < startWords.length; i++) {
            BuildTrie(startWords[i], root);
        }
        int count = 0;
        for (int i = 0; i < targetWords.length; i++) {
            char[] target = targetWords[i].toCharArray();
            Arrays.sort(target);
            if (isFound(target, root)) {
                count++;
            }
        }
        return count;
    }

    private boolean isFound(char[] target, Trie root) {
        for (int i = 0; i < target.length; i++) {
            Trie temp = root;
            for (int j = 0; j < target.length; j++) {
                if (j == i) {
                    if (j == target.length - 1) {
                        if (temp.isEnd) {
                            return true;
                        }
                    }
                    continue;
                }
                if (temp.children[target[j] - 'a'] == null) {
                    break;
                }
                temp = temp.children[target[j] - 'a'];
                if (j == target.length - 1) {
                    if (temp.isEnd) {
                        return true;
                    };
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CountWordsObtainedAfterAddingaLetter cwoaal = new CountWordsObtainedAfterAddingaLetter();
        String[] startWords = new String[]{"ab", "a"};
        String[] targetWords = new String[]{"abc", "abcd"};
//        String[] startWords = new String[]{"ant", "act", "tack"};
//        String[] targetWords = new String[]{"tack", "act", "acti"};
//        String[] startWords = new String[]{"lhum", "bim", "cyjhm", "h", "a", "ljxd", "run", "zrl", "dmf", "y"};
//        String[] targetWords = new String[]{"da", "lzkr", "uzc", "jdxlz", "yt", "emdf"};
//        String[] startWords = new String[]{"uh"};
//        String[] targetWords = new String[]{"u", "hur", "k", "b", "u", "yse", "giqoy", "lni", "olqb", "nemc"};
        System.out.println(cwoaal.wordCount(startWords, targetWords));
    }
}
