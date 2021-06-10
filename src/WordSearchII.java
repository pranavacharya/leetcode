
import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList();

        for (String word : words) {
            outer:
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        if (findWord(board, i, j, word, 0)) {
                            ans.add(word);
                            break outer;
                        }
                    }
                }
            }
        }

        return ans;
    }

    private boolean findWord(char[][] board, int i, int j, String word, int index) {
        if (index == word.length() || index == 0 && word.length() == 1) {
            return true;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        char c = board[i][j];
        board[i][j] = '.';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length) {
                if (findWord(board, x, y, word, index + 1)) {
                    board[i][j] = c;
                    return true;
                }
            }
        }
        board[i][j] = c;
        return false;
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
