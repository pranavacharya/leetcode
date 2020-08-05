
public class AddandSearchWordDatastructuredesign {

    public class TrieNode {

        private TrieNode[] next;
        private boolean isEnd;

        public TrieNode() {
            this.next = new TrieNode[26];
            this.isEnd = false;
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        public boolean hasChar(char value) {
            return this.next[value - 'a'] != null;
        }

        public void add(char value) {
            this.next[value - 'a'] = new TrieNode();
        }

        public void setEnd() {
            this.isEnd = true;
        }

    }

    private TrieNode root;

    public AddandSearchWordDatastructuredesign() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        int index = 0;
        TrieNode head = root;
        while (index < word.length() && head.hasChar(word.charAt(index))) {
            head = head.next[word.charAt(index) - 'a'];
            index++;
        }
        if (index == word.length()) {
            head.setEnd();
        } else {
            for (int i = index; i < word.length(); i++) {
                head.add(word.charAt(i));
                head = head.next[word.charAt(i) - 'a'];
            }
            head.setEnd();
        }
    }

    private boolean backtrack(TrieNode head, int index, String word) {
        if (index == word.length()) {
            return head != null && head.isEnd;
        } else if (head == null) {
            return false;
        } else {
            if (word.charAt(index) == '.') {
                for (char i = 'a'; i <= 'z'; i++) {
                    if (backtrack(head.next[i - 'a'], index + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (head.hasChar(word.charAt(index))) {
                    if (backtrack(head.next[word.charAt(index) - 'a'], index + 1, word)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    }

    public boolean search(String word) {
        TrieNode head = root;
        return backtrack(head, 0, word);
    }

    public static void main(String args[]) {
        AddandSearchWordDatastructuredesign asw = new AddandSearchWordDatastructuredesign();
        asw.addWord("a");
        asw.addWord("a");
        System.out.println(asw.search("."));
        System.out.println(asw.search("a"));
        System.out.println(asw.search("aa"));
        System.out.println(asw.search("a"));
        System.out.println(asw.search(".a"));
        System.out.println(asw.search("a."));

    }
}
