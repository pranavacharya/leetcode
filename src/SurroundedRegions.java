
import java.util.Arrays;

public class SurroundedRegions {

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        board[row][col] = 'B';
        for (int[] dir : dirs) {
            if (row + dir[0] < board.length && col + dir[1] < board[row].length && row + dir[0] >= 0 && col + dir[1] >= 0 && board[row + dir[0]][col + dir[1]] == 'O') {
                dfs(board, row + dir[0], col + dir[1]);
            }
        }
    }

    public static void main(String args[]) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = new char[][]{
            {'O', 'O', 'O', 'O', 'X', 'X'},
            {'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'X', 'O', 'X', 'O', 'O'},
            {'O', 'X', 'O', 'O', 'X', 'O'},
            {'O', 'X', 'O', 'X', 'O', 'O'},
            {'O', 'X', 'O', 'O', 'O', 'O'}};
        sr.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
