
import java.util.Arrays;

public class SurroundedRegions {

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    if (dfs(board, i, j)) {
                        board[i][j] = 'X';
                    };
                }
            }
        }
    }

    public boolean dfs(char[][] board, int row, int col) {
        if (row == board.length - 1 || col == board[row].length - 1 || row == 0 || col == 0) {
            return false;
        } else {
            boolean status = true;
            board[row][col] = 'X';
            for (int[] dir : dirs) {
                if (board[row + dir[0]][col + dir[1]] == 'O') {
                    status = status && dfs(board, row + dir[0], col + dir[1]);
                }
                if (!status) {
                    break;
                }
            }
            board[row][col] = 'O';
            return status;
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
