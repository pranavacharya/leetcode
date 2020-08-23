
public class StreamofCharacters {

    public class Trie {

        private Trie[] node;

        private boolean isEnd;

        public Trie() {
            this.isEnd = false;
            this.node = new Trie[26];
        }
    }

    private Trie root;
    StringBuilder sb;

    public StreamofCharacters(String[] words) {
        root = new Trie();
        for (String word : words) {
            insertWord(word);
        }
        sb = new StringBuilder();
    }

    private void insertWord(String word) {
        Trie head = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (head.node[c - 'a'] == null) {
                Trie temp = new Trie();
                head.node[c - 'a'] = temp;
            }
            head = head.node[c - 'a'];
        }
        head.isEnd = true;
    }

    public boolean query(char letter) {
        Trie head = root;
        sb.append(letter);
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (head.node[sb.charAt(i) - 'a'] == null) {
                return false;
            } else {
                head = head.node[sb.charAt(i) - 'a'];
            }
            if (head.isEnd) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String[] words = new String[]{"abc", "abdf", "pranav"};
        StreamofCharacters soc = new StreamofCharacters(words);
        System.out.println(soc.query('a'));
        System.out.println(soc.query('b'));
        System.out.println(soc.query('c'));
        System.out.println(soc.query('c'));
    }
}
