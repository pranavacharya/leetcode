
public class WordSearch {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0
                || j >= board[i].length || j < 0) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        char value = board[i][j];
        board[i][j] = '#';
        for (int[] dir : dirs) {
            if (dfs(board, i + dir[0], j + dir[1], word, index + 1)) {
                return true;
            }
        }
        board[i][j] = value;
        return false;
    }

    public static void main(String args[]) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "FCEDASD"));
    }
}
