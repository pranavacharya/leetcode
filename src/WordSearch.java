
public class WordSearch {

    private int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        } else if (row < 0 || col < 0
                || row >= board.length || col >= board[row].length) {
            return false;
        } else if (board[row][col] == word.charAt(index)) {
            for (int[] d : dir) {
                char temp = board[row][col];
                board[row][col] = '1';
                if (dfs(board, word, index + 1, row + d[0], col + d[1])) {
                    return true;
                } else {
                    board[row][col] = temp;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "FCEDASD"));
    }
}
