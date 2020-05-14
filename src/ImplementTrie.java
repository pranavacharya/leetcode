
import java.util.HashSet;

public class ImplementTrie {

    HashSet<String> set;

    /**
     * Initialize your data structure here.
     */
    public ImplementTrie() {
        this.set = new HashSet();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        this.set.add(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return this.set.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix) {
        for (String s : set) {
            if (s.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
