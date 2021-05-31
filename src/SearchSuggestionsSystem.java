
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

    class Trie {

        Trie[] children = new Trie[26];
        boolean isEnd;
        List<String> list;
    }

    private Trie root;

    private void add(String word) {
        Trie temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new Trie();
                temp.children[c - 'a'].list = new ArrayList();
            }
            temp = temp.children[c - 'a'];
            temp.list.add(word);
            if (temp.list.size() > 3) {
                temp.list.remove(temp.list.size() - 1);
            }
        }
        temp.isEnd = true;
    }

    private List<String> fetchWithPrefix(String prefix) {
        Trie temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (temp.children[c - 'a'] == null) {
                return new ArrayList();
            } else {
                temp = temp.children[c - 'a'];
            }
        }
        return temp.list;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList();
        this.root = new Trie();
        Arrays.sort(products);
        for (String product : products) {
            add(product);
        }
        for (int i = 1; i <= searchWord.length(); i++) {
            list.add(fetchWithPrefix(searchWord.substring(0, i)));
        }
        return list;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem sss = new SearchSuggestionsSystem();
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        System.out.println(sss.suggestedProducts(products, "mouse"));
    }
}
