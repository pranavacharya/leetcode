
import java.util.HashSet;

public class PrefixandSuffixSearch {

    class Trie {

        Trie[] children = new Trie[26];
        boolean isWord = false;
        HashSet<Integer> set = new HashSet();
    }

    private Trie prefixTrie;
    private Trie suffixTrie;

    private void buildTrie(Trie root, String[] words, int order) {
        for (int i = 0; i < words.length; i++) {
            Trie temp = root;
            String word = words[i];
            if (order == 1) {
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    if (temp.children[c - 'a'] == null) {
                        temp.children[c - 'a'] = new Trie();
                    }
                    temp = temp.children[c - 'a'];
                    temp.set.add(i);
                }
                temp.isWord = true;
            } else {
                for (int j = word.length() - 1; j >= 0; j--) {
                    char c = word.charAt(j);
                    if (temp.children[c - 'a'] == null) {
                        temp.children[c - 'a'] = new Trie();
                    }
                    temp = temp.children[c - 'a'];
                    temp.set.add(i);
                }
                temp.isWord = true;
            }
        }
    }

    private HashSet<Integer> searchTrie(Trie root, String prefix) {
        HashSet<Integer> ids = new HashSet();
        Trie temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (temp.children[c - 'a'] == null) {
                return new HashSet();
            } else {
                temp = temp.children[c - 'a'];
                ids = new HashSet(temp.set);
            }
        }
        return ids;
    }

    public PrefixandSuffixSearch(String[] words) {
        this.prefixTrie = new Trie();
        this.suffixTrie = new Trie();
        buildTrie(prefixTrie, words, 1);
        buildTrie(suffixTrie, words, 0);
    }

    public int f(String prefix, String suffix) {
        HashSet<Integer> prefixSet = searchTrie(prefixTrie, prefix);
        StringBuilder sb = new StringBuilder();
        sb.append(suffix);
        String revSuff = sb.reverse().toString();
        HashSet<Integer> suffixSet = searchTrie(suffixTrie, revSuff);
        prefixSet.retainAll(suffixSet);
        int max = -1;
        for (int index : prefixSet) {
            max = Math.max(max, index);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"};
        PrefixandSuffixSearch pss = new PrefixandSuffixSearch(words);
        System.out.println(pss.f("a", "aa"));
        System.out.println(pss.f("bccbacbcba", "a"));
    }

}
