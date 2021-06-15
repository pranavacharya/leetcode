
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckifThereisaValidPathinaGrid {

    private HashMap<Integer, List<int[]>> map = new HashMap();

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i <= 6; i++) {
            this.map.put(i, new ArrayList());
        }
        this.map.get(1).add(new int[]{0, 1});
        this.map.get(1).add(new int[]{0, -1});
        this.map.get(2).add(new int[]{1, 0});
        this.map.get(2).add(new int[]{-1, 0});
        this.map.get(3).add(new int[]{1, 0});
        this.map.get(3).add(new int[]{0, -1});
        this.map.get(4).add(new int[]{0, 1});
        this.map.get(4).add(new int[]{1, 0});
        this.map.get(5).add(new int[]{0, -1});
        this.map.get(5).add(new int[]{-1, 0});
        this.map.get(6).add(new int[]{-1, 0});
        this.map.get(6).add(new int[]{0, 1});

        boolean[][] visited = new boolean[m][n];
        return dfs(grid, visited, 0, 0);
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return true;
        }
        int curr = grid[i][j];
        visited[i][j] = true;
        List<int[]> dirs = this.map.get(curr);
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && !visited[x][y]) {
                boolean flag = false;
                List<int[]> revDirs = this.map.get(grid[x][y]);
                for (int[] revDir : revDirs) {
                    int x1 = revDir[0] + x;
                    int y1 = revDir[1] + y;
                    if (i == x1 && j == y1) {
                        flag = true;
                        break;
                    }
                }
                if (flag && dfs(grid, visited, x, y)) {
                    visited[i][j] = false;
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        CheckifThereisaValidPathinaGrid citvp = new CheckifThereisaValidPathinaGrid();
        int[][] grid = new int[][]{{2, 4, 3}, {6, 5, 2}};
        System.out.println(citvp.hasValidPath(grid));
    }
}
