
import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> list = new ArrayList<>();
        permutation(n, 0, board, list);
        return list;
    }

    public void permutation(int n, int col, char[][] board, List<List<String>> list) {
        if (n == 0) {
            ArrayList<String> matrix = new ArrayList();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    sb.append(board[i][j]);
                }
                matrix.add(sb.toString());
            }
            list.add(matrix);
        } else {
            for (int j = col; j < board.length && board.length - (j + 1) == n - 1; j++) {
                for (int i = 0; i < board.length; i++) {
                    if (isSafe(board, i, j)) {
                        board[i][j] = 'Q';
                        permutation(n - 1, j + 1, board, list);
                        board[i][j] = '.';
                    }
                }
            }
        }
    }

    public boolean isSafe(char board[][], int row, int col) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        NQueens nq = new NQueens();
        System.out.println(nq.solveNQueens(4));
    }
}
