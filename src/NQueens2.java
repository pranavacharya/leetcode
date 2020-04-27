
import java.util.Arrays;

public class NQueens2 {

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        int count = permutations(board, n, 0);
        return count;
    }

    public int permutations(int[][] board, int n, int row) {
        if (n == 0) {
            System.out.println(Arrays.deepToString(board));
            return 1;
        } else {
            int count = 0;
            for (int i = row; i < board.length && board.length - i == n; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (isSafe(board, i, j)) {
                        board[i][j] = 1;
                        count += permutations(board, n - 1, i + 1);
                        board[i][j] = 0;
                    }
                }
            }
            return count;
        }
    }

    public boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        NQueens2 nq2 = new NQueens2();
        System.out.println(nq2.totalNQueens(8));
    }
}
