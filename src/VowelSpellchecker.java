
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class VowelSpellchecker {

    private HashSet<Character> set = new HashSet();

    public VowelSpellchecker() {
        this.set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    class Trie {

        List<String> words = new ArrayList();
        Trie[] childern = new Trie[27];
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Trie root = buildTrie(wordlist);
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = findWord(root, queries[i]);
        }
        return res;
    }

    private Trie buildTrie(String[] wordlist) {
        Trie root = new Trie();
        for (String word : wordlist) {
            Trie temp = root;
            for (int j = 0; j < word.length(); j++) {
                char c = Character.toLowerCase(word.charAt(j));
                if (this.set.contains(c)) {
                    // char after z in ascii
                    c = '{';
                }
                if (temp.childern[c - 'a'] == null) {
                    temp.childern[c - 'a'] = new Trie();
                }
                temp = temp.childern[c - 'a'];
            }
            temp.words.add(word);
        }
        return root;
    }

    private String findWord(Trie root, String word) {
        Trie temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (this.set.contains(c)) {
                // char after z in ascii
                c = '{';
            }
            if (temp.childern[c - 'a'] == null) {
                return "";
            } else {
                temp = temp.childern[c - 'a'];
            }
        }
        List<String> words = temp.words;
        if (words.contains(word)) {
            return word;
        }
        return words.isEmpty() ? "" : words.get(0);
    }

    public static void main(String[] args) {
        VowelSpellchecker vs = new VowelSpellchecker();
        String[] wordlist = new String[]{"KiTe", "kite", "hare", "Hare"};
        String[] queries = new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        System.out.println(Arrays.toString(vs.spellchecker(wordlist, queries)));
    }
}
