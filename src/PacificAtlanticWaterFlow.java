
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        bfs(matrix, visitedPacific, new boolean[m][n], true, m, n);
        bfs(matrix, visitedAtalantic, new boolean[m][n], false, m, n);
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedAtalantic[i][j] && visitedPacific[i][j]) {
                    List<Integer> point = new ArrayList();
                    point.add(i);
                    point.add(j);
                    result.add(point);
                }
            }
        }
        return result;
    }

    private void bfs(int[][] matrix, boolean[][] canReach,
            boolean[][] visited, boolean isPacific, int m, int n) {
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isPacific) {
                    if (i == 0 || j == 0) {
                        visited[i][j] = true;
                        queue.add(new int[]{i, j});
                    }
                } else {
                    if (i == m - 1 || j == n - 1) {
                        visited[i][j] = true;
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            canReach[curr[0]][curr[1]] = true;
            for (int[] dir : dirs) {
                if (row + dir[0] >= 0 && row + dir[0] < m && col + dir[1] >= 0
                        && col + dir[1] < n
                        && !visited[row + dir[0]][col + dir[1]]
                        && matrix[row][col] <= matrix[row + dir[0]][col + dir[1]]) {
                    visited[row + dir[0]][col + dir[1]] = true;
                    queue.add(new int[]{row + dir[0], col + dir[1]});
                }
            }
        }

    }

    public static void main(String[] args) {

        PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
        int[][] matrix = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pawf.pacificAtlantic(matrix));
    }
}
