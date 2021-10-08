
public class WordSearch {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }

        if (word.charAt(index) != board[i][j]) {
            return false;
        }

        char c = board[i][j];

        board[i][j] = '*';

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (dfs(board, word, index + 1, x, y)) {
                return true;
            }
        }

        board[i][j] = c;
        return false;
    }

    public static void main(String args[]) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "FCEDASD"));
        System.out.println(ws.exist(board, "ABCB"));
    }
}
