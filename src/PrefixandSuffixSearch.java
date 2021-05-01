
public class PrefixandSuffixSearch {

    class Trie {

        Trie[] children = new Trie[27];
        boolean isWord = false;
        int index = 0;
    }

    private Trie root;

    private void buildTrie(Trie root, String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i] + "{";
            for (int j = 0; j < word.length(); j++) {
                Trie temp = root;
                temp.index = i;
                for (int k = j; k < 2 * word.length() - 1; k++) {
                    char c = word.charAt(k % word.length());
                    if (temp.children[c - 'a'] == null) {
                        temp.children[c - 'a'] = new Trie();
                    }
                    temp = temp.children[c - 'a'];
                    temp.index = i;
                }
                temp.isWord = true;
            }
        }
    }

    private int searchTrie(String word) {
        Trie temp = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                return -1;
            } else {
                temp = temp.children[c - 'a'];
            }
        }
        return temp.index;
    }

    public PrefixandSuffixSearch(String[] words) {
        this.root = new Trie();
        buildTrie(root, words);
    }

    public int f(String prefix, String suffix) {
        String word = suffix + "{" + prefix;
        return searchTrie(word);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"};
        PrefixandSuffixSearch pss = new PrefixandSuffixSearch(words);
        System.out.println(pss.f("a", "aa"));
        System.out.println(pss.f("bccbacbcba", "a"));
    }

}
