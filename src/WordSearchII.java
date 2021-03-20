
import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    class Trie {

        String word;
        Trie[] child = new Trie[26];
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        List<String> ans = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, root, ans, i, j);
            }
        }
        return ans;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie temp = root;
            int j = 0;
            while (j < word.length() && temp.child[word.charAt(j) - 'a'] != null) {
                temp = temp.child[word.charAt(j) - 'a'];
                j++;
            }

            for (int k = j; k < word.length(); k++) {
                temp.child[word.charAt(k) - 'a'] = new Trie();
                temp = temp.child[word.charAt(k) - 'a'];
            }

            temp.word = word;
        }
        return root;
    }

    private void dfs(char[][] board, Trie root, List<String> ans, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return;
        }
        char curr = board[row][col];
        if (curr != '.' && root.child[curr - 'a'] != null) {
            root = root.child[curr - 'a'];
            if (root.word != null) {
                ans.add(root.word);
                root.word = null;
            }
            board[row][col] = '.';
            for (int[] dir : dirs) {
                dfs(board, root, ans, row + dir[0], col + dir[1]);
            }
            board[row][col] = curr;
        }
    }

    public static void main(String[] args) {
        WordSearchII ws2 = new WordSearchII();
//        char[][] board = new char[][]{{'a', 'a'}};
//        String[] words = new String[]{"aaa"};
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(ws2.findWords(board, words));
    }
}
