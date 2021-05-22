
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList();
        char[][] grid = new char[n][n];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], '.');
        }
        backtracking(0, grid, list);
        return list;
    }

    private void backtracking(int i, char[][] grid, List<List<String>> list) {
        if (i == grid.length) {
            list.add(generateList(grid));
            return;
        }
        for (int j = 0; j < grid[i].length; j++) {
            if (isValid(grid, i, j)) {
                grid[i][j] = 'Q';
                backtracking(i + 1, grid, list);
                grid[i][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] grid, int i, int j) {
        for (int k = 0; k < grid.length; k++) {
            if (grid[k][j] == 'Q') {
                return false;
            }
            for (int l = 0; l < grid[i].length; l++) {
                if (k == 0) {
                    if (grid[i][l] == 'Q') {
                        return false;
                    }
                }
                if (Math.abs(k - i) == Math.abs(l - j) && grid[k][l] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> generateList(char[][] grid) {
        List<String> combo = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            String row = new String(grid[i]);
            combo.add(row);
        }
        return combo;
    }

    public static void main(String args[]) {
        NQueens nq = new NQueens();
        System.out.println(nq.solveNQueens(4));
    }
}
