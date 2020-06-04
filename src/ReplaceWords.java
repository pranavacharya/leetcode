
import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

    public class TrieNode {

        TrieNode[] links;
        boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

    }

    TrieNode root;

    public ReplaceWords() {
        this.root = new TrieNode();
    }

    public boolean isEnd(TrieNode node) {
        return node.isEnd;
    }

    public boolean contains(TrieNode node, char c) {
        return node.links[c - 'a'] != null;
    }

    public void addWord(String word) {
        TrieNode head = root;
        int i = 0;
        while (i < word.length() && contains(head, word.charAt(i))) {
            head = head.links[word.charAt(i) - 'a'];
            i++;
        }
        while (i < word.length()) {
            TrieNode temp = new TrieNode();
            head.links[word.charAt(i) - 'a'] = temp;
            head = head.links[word.charAt(i) - 'a'];
            i++;
        }
        head.isEnd = true;
    }

    public String searchPrefix(String word) {
        TrieNode head = root;
        int i = 0;
        StringBuilder prefix = new StringBuilder();
        while (i < word.length() && contains(head, word.charAt(i))) {
            prefix.append(word.charAt(i));
            head = head.links[word.charAt(i) - 'a'];
            if (isEnd(head)) {
                return prefix.toString();
            }
            i++;
        }
        return "";
    }

    public String replaceWords(List<String> dict, String sentence) {
        for (String word : dict) {
            addWord(word);
        }
        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            String root = searchPrefix(word);
            if (!root.isBlank() || !root.isEmpty()) {
                result.append(root);
            } else {
                result.append(word);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String args[]) {
        ReplaceWords pw = new ReplaceWords();
        List<String> dict = new ArrayList();
        dict.add("catt");
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        System.out.println(pw.replaceWords(dict, "the cattle was rattled by the battery"));
    }
}
