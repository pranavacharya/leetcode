
import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Trie {

        Trie[] children = new Trie[26];
        boolean isEnd = false;
        String word;
    }

    private void addWord(Trie root, String word) {
        Trie temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new Trie();
            }
            temp = temp.children[c - 'a'];
        }
        temp.isEnd = true;
        temp.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i]);
        }
        List<String> result = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, root, result, i, j);
            }
        }
        return result;
    }

    private void dfs(char[][] board, Trie root, List<String> list, int i, int j) {
        if (root == null) {
            return;
        }
        char c = board[i][j];

        if (board[i][j] == '#' || root.children[c - 'a'] == null) {
            return;
        }
        root = root.children[c - 'a'];
        if (root != null && root.isEnd) {
            list.add(root.word);
            root.isEnd = false;
        }
        board[i][j] = '#';

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length) {
                dfs(board, root, list, x, y);
            }
        }

        board[i][j] = c;
    }

    public static void main(String[] args) {
        WordSearchII ws2 = new WordSearchII();
        char[][] board = new char[][]{{'a', 'a'}};
        String[] words = new String[]{"aaa"};
//        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(ws2.findWords(board, words));
    }
}
