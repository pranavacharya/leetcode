
import java.util.ArrayList;

public class DetectCyclesin2DGrid {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ArrayList<String> path = new ArrayList();
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, visited, path)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, int row, int col,
            boolean[][] visited, ArrayList<String> path) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return false;
        }
        if (path.contains("" + row + " " + col)
                && path.get(path.size() - 2).equals("" + row + " " + col)) {
            return false;
        }
        if (path.contains("" + row + " " + col)) {
            return true;
        }
        path.add("" + row + " " + col);
        boolean status = false;
        for (int[] dir : dirs) {
            if (row + dir[0] >= 0 && col + dir[1] >= 0
                    && row + dir[0] < grid.length && col + dir[1] < grid[row].length
                    && grid[row][col] == grid[row + dir[0]][col + dir[1]]) {
                status = status || dfs(grid, row + dir[0], col + dir[1], visited, path);
                if (status) {
                    return true;
                }
            }
        }
        if (!status) {
            visited[row][col] = true;
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
