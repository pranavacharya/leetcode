
public class AddandSearchWordDatastructuredesign {

    public class TrieNode {

        private TrieNode[] links;
        private int L = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[L];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        public TrieNode getLink(char c) {
            return this.links[c - 'a'];
        }

        public void putLink(char c, TrieNode node) {
            this.links[c - 'a'] = node;
        }

        public boolean containsKet(char c) {
            return links[c - 'a'] != null;
        }

    }

    private TrieNode root;

    public AddandSearchWordDatastructuredesign() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode head = root;
        char[] arr = word.toCharArray();
        int index = 0;
        while (index < arr.length && head.containsKet(arr[index])) {
            head = head.getLink(arr[index]);
            index++;
        }
        while (index < arr.length) {
            head.putLink(arr[index], new TrieNode());
            head = head.getLink(arr[index]);
            index++;
        }
        head.setEnd();
    }

    private boolean backtrack(TrieNode head, String word, int index) {
        if (index == word.length()) {
            return head != null && head.isEnd();
        } else if (head == null) {
            return false;
        } else {
            for (int i = index; i < word.length(); i++) {
                if (word.charAt(i) != '.') {
                    if (head.containsKet(word.charAt(i))) {
                        if (backtrack(head.getLink(word.charAt(i)), word, index + 1)) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (backtrack(head.getLink(j), word, index + 1)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    }

    public boolean search(String word) {
        TrieNode head = root;
        return backtrack(head, word, 0);
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
