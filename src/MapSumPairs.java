
import java.util.HashMap;

public class MapSumPairs {

    class Trie {

        Trie[] nodes = new Trie[26];
        int sum = 0;
    }

    Trie root;
    HashMap<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSumPairs() {
        this.root = new Trie();
        this.map = new HashMap();
    }

    public void insert(String key, int val) {
        int alter = this.map.getOrDefault(key, 0);
        Trie temp = this.root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (temp.nodes[c - 'a'] == null) {
                temp.nodes[c - 'a'] = new Trie();
            }
            temp = temp.nodes[c - 'a'];
            temp.sum += val;
            temp.sum -= alter;
        }
        this.map.put(key, val);
    }

    public int sum(String prefix) {
        Trie temp = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (temp.nodes[c - 'a'] == null) {
                return 0;
            } else {
                temp = temp.nodes[c - 'a'];
            }
        }
        return temp.sum;
    }

    public static void main(String[] args) {
        MapSumPairs mapSum = new MapSumPairs();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)
    }
}
