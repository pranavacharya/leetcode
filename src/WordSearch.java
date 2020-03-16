
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        if (dfs(board, i, j, word, 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
        if (index >= word.length()) {
            return false;
        } else if (index == word.length() - 1) {
            return word.charAt(index) == board[i][j];
        } else if (word.charAt(index) == board[i][j]) {
            char character = board[i][j];
            boolean right, left, top, bottom;
            board[i][j] = '0';
            right = dfs(board, i + 1, j, word, index + 1);
            bottom = dfs(board, i, j + 1, word, index + 1);
            left = dfs(board, i - 1, j, word, index + 1);
            top = dfs(board, i, j - 1, word, index + 1);
            board[i][j] = character;
            return (right || left || top || bottom);
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(ws.exist(board, "FCEDASD"));
    }
}
