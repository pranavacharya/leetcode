
public class WordSearch {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

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

    private boolean dfs(char[][] board, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        char c = board[x][y];
        board[x][y] = '#';

        for (int[] dir : dirs) {
            int nx = dir[0] + x;
            int ny = dir[1] + y;

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[nx].length) {
                if (dfs(board, word, index + 1, nx, ny)) {
                    board[x][y] = c;
                    return true;
                }
            }
        }

        board[x][y] = c;
        return index + 1 == word.length();
    }

    public static void main(String args[]) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "FCEDASD"));
        System.out.println(ws.exist(board, "ABCB"));
    }
}
