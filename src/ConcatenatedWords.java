
import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {

    class Trie {

        Trie[] children = new Trie[26];
        boolean isEnd;
    }

    private Trie root;

    private void buildTrie(String word) {
        Trie temp = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new Trie();
            }
            temp = temp.children[c - 'a'];
        }
        temp.isEnd = true;
    }

    private boolean findIsConcatenated(String word, int index, int parts) {
        if (word.isEmpty()) {
            return false;
        }
        if (index == word.length()) {
            return parts != 1;
        }
        Trie temp = this.root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                return false;
            } else {
                temp = temp.children[c - 'a'];
                // is end
                if (temp.isEnd) {
                    if (findIsConcatenated(word, i + 1, parts + 1)) {
                        return true;
                    };
                }
            }
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.root = new Trie();
        List<String> result = new ArrayList();
        for (String word : words) {
            buildTrie(word);
        }
        for (String word : words) {
            if (findIsConcatenated(word, 0, 0)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ConcatenatedWords cw = new ConcatenatedWords();
        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(cw.findAllConcatenatedWordsInADict(words));
    }
}
