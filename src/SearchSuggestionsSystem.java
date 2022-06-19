
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

    public class Trie {

        Trie[] node = new Trie[26];
        boolean isEnd;
        List<String> list = new ArrayList();
    }

    public void addWord(Trie root, String word) {
        Trie temp = root;
        for (char c : word.toCharArray()) {
            if (temp.node[c - 'a'] == null) {
                temp.node[c - 'a'] = new Trie();
            }
            temp = temp.node[c - 'a'];
            if (temp.list.size() < 3) {
                temp.list.add(word);
            }
        }
        temp.isEnd = true;
    }

    public List<List<String>> findList(Trie root, String searchWord) {
        List<List<String>> result = new ArrayList();
        Trie temp = root;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            if (temp.node[c - 'a'] == null) {
                for (int j = i; j < searchWord.length(); j++) {
                    result.add(new ArrayList());
                }
                return result;
            } else {
                temp = temp.node[c - 'a'];
                result.add(temp.list);
            }
        }
        return result;
    }

    public Trie root;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        this.root = new Trie();
        Arrays.sort(products);
        for (String product : products) {
            addWord(this.root, product);
        }
        return findList(this.root, searchWord);
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem sss = new SearchSuggestionsSystem();
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        System.out.println(sss.suggestedProducts(products, "mouse"));
    }
}
