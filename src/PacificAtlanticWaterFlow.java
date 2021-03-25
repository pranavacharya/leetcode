
import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList();
        }
        int n = matrix[0].length;
        boolean[][] visitedPacific = new boolean[m][n];
        boolean[][] visitedAtalantic = new boolean[m][n];
        boolean[][] isValidPacific = new boolean[m][n];
        boolean[][] isValidAtlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitAtlanticFromNode(matrix, visitedAtalantic, isValidAtlantic, new boolean[m][n], i, j, m, n)
                        && visitPacficFromNode(matrix, visitedPacific, isValidPacific, new boolean[m][n], i, j, m, n)) {
                    List<Integer> point = new ArrayList();
                    point.add(i);
                    point.add(j);
                    result.add(point);
                }
            }
        }
        return result;
    }

    private boolean visitPacficFromNode(int[][] matrix, boolean[][] visited,
            boolean[][] isValid, boolean[][] visiting, int row, int col, int m, int n) {

        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }

        if (visited[row][col]) {
            return isValid[row][col];
        }

        boolean isPacific = false;
        if (row == 0 || col == 0) {
            isPacific = true;
        }

        if (isPacific) {
            visited[row][col] = true;
            isValid[row][col] = isPacific;
            return isValid[row][col];
        }

        visiting[row][col] = true;
        for (int[] dir : dirs) {
            if (row + dir[0] < 0 || row + dir[0] >= m || col + dir[1] < 0 || col + dir[1] >= n) {
                continue;
            }
            if (matrix[row][col] >= matrix[row + dir[0]][col + dir[1]]
                    && !visiting[row + dir[0]][col + dir[1]]
                    && visitPacficFromNode(matrix, visited, isValid, visiting, row + dir[0], col + dir[1], m, n)) {
                isPacific = true;
                break;
            }
        }
        visiting[row][col] = false;
        if (isPacific) {
            visited[row][col] = true;
        }
        isValid[row][col] = isPacific;
        return isValid[row][col];
    }

    private boolean visitAtlanticFromNode(int[][] matrix, boolean[][] visited,
            boolean[][] isValid, boolean[][] visiting, int row, int col, int m, int n) {

        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }

        if (visited[row][col]) {
            return isValid[row][col];
        }

        boolean isAtlantic = false;

        if (row == m - 1 || col == n - 1) {
            isAtlantic = true;
        }
        if (isAtlantic) {
            visited[row][col] = true;
            isValid[row][col] = isAtlantic;
            return isValid[row][col];
        }
        visiting[row][col] = true;
        for (int[] dir : dirs) {
            if (row + dir[0] < 0 || row + dir[0] >= m || col + dir[1] < 0 || col + dir[1] >= n) {
                continue;
            }
            if (matrix[row][col] >= matrix[row + dir[0]][col + dir[1]]
                    && !visiting[row + dir[0]][col + dir[1]]
                    && visitAtlanticFromNode(matrix, visited, isValid, visiting, row + dir[0], col + dir[1], m, n)) {
                isAtlantic = true;
                break;
            }
        }
        visiting[row][col] = false;
        if (isAtlantic) {
            visited[row][col] = true;
        }
        isValid[row][col] = isAtlantic;
        return isValid[row][col];
    }

    public static void main(String[] args) {

        PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
        int[][] matrix = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pawf.pacificAtlantic(matrix));
    }
}
