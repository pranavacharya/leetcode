
public class MakingALargeIsland {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        int largest = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    largest = Math.max(largest, helper(grid, i, j, new boolean[grid.length][grid[0].length]));
                    grid[i][j] = 0;
                }
            }
        }
        return largest == -1 ? grid.length * grid[0].length : largest;
    }

    private int helper(int[][] grid, int i, int j, boolean[][] visited) {
        int ans = 1;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == 1 && !visited[x][y]) {
                ans += helper(grid, x, y, visited);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MakingALargeIsland mali = new MakingALargeIsland();
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        System.out.println(mali.largestIsland(grid));
    }
}
