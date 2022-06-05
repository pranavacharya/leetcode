
import java.util.Arrays;

public class NQueens2 {

    int count;

    public int totalNQueens(int n) {
        this.count = 0;
        int[][] grid = new int[n][n];
        backtrack(grid, 0, 0, n);
        return this.count;
    }

    private void backtrack(int[][] grid, int row, int col, int n) {
        if (n == 0) {
            this.count++;
            return;
        }

        if (row == grid.length) {
            return;
        }

        if (isValid(grid, row, col)) {
            grid[row][col] = 1;
            if (col == grid.length - 1) {
                backtrack(grid, row + 1, 0, n - 1);
            } else {
                backtrack(grid, row, col + 1, n - 1);
            }
            grid[row][col] = 0;
        }

        if (col == grid.length - 1) {
            backtrack(grid, row + 1, 0, n);
        } else {
            backtrack(grid, row, col + 1, n);
        }

    }

    private boolean isValid(int[][] grid, int row, int col) {
        int rowcount = 0;
        int colcount = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == 1) {
                rowcount++;
                break;
            }
            if (grid[i][col] == 1) {
                colcount++;
                break;
            }
        }
        if (rowcount > 0 || colcount > 0) {
            return false;
        }

        int diacount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1 && Math.abs(row - i) == Math.abs(col - j)) {
                    diacount++;
                    break;
                }
            }
        }
        if (diacount > 0) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        NQueens2 nq2 = new NQueens2();
        System.out.println(nq2.totalNQueens(8));
    }
}
