
import java.util.ArrayList;

public class DetectCyclesin2DGrid {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && dfs(grid, visited, i, j, new ArrayList())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, ArrayList<String> path) {
        if (visited[i][j]) {
            System.out.println("i " + i + " j " + j);
            return true;
        }
        String lastPath = path.isEmpty() ? "" : path.get(path.size() - 1);
        path.add("i " + i + " j " + j);
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == grid[i][j]) {
                String nextPath = new String("i " + x + " j " + y);
                if (!lastPath.equals(nextPath) && dfs(grid, visited, x, y, path)) {
                    return true;
                }

            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String args[]) {
        char[][] grid = new char[][]{{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        DetectCyclesin2DGrid dc2dg = new DetectCyclesin2DGrid();
        System.out.println(dc2dg.containsCycle(grid));
    }
}
