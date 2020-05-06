
import java.util.Arrays;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtracking(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char k) {
        //row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == k) {
                return false;
            }
        }
        //column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) {
                return false;
            }
        }
        //box
        for (int i = 0; i < 9; i++) {
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        SudokuSolver ss = new SudokuSolver();
//        char[][] board = new char[][]{
//            {'.', '5', '.', '.', '6', '.', '.', '4', '.'},
//            {'.', '.', '6', '2', '4', '7', '.', '9', '1'},
//            {'.', '.', '.', '1', '9', '.', '.', '.', '.'},
//            {'.', '.', '.', '6', '.', '.', '9', '.', '.'},
//            {'2', '.', '.', '.', '.', '.', '.', '8', '4'},
//            {'.', '.', '.', '3', '.', '.', '.', '.', '5'},
//            {'.', '3', '1', '.', '.', '.', '.', '.', '8'},
//            {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
//            {'.', '.', '4', '.', '.', '.', '2', '5', '.'}
//        };
        char[][] board = new char[][]{
            {'.', '.', '.', '5', '9', '6', '8', '.', '.'},
            {'.', '8', '.', '.', '7', '2', '.', '.', '1'},
            {'4', '.', '7', '1', '.', '8', '.', '9', '.'},
            {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
            {'.', '7', '1', '6', '.', '3', '.', '.', '.'},
            {'2', '3', '5', '.', '8', '.', '.', '1', '.'},
            {'1', '.', '.', '.', '.', '5', '.', '.', '9'},
            {'.', '.', '4', '7', '2', '.', '.', '.', '.'},
            {'7', '9', '.', '3', '4', '.', '6', '.', '5'}
        };
        ss.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
