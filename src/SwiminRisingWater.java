
public class SwiminRisingWater {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        int low = grid[0][0];
        int high = grid.length * grid.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (helper(grid, 0, 0, new boolean[grid.length][grid.length], mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean helper(int[][] grid, int i, int j, boolean[][] visited, int max) {
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length
                    && !visited[x][y] && grid[x][y] <= max) {
                if (helper(grid, x, y, visited, max)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwiminRisingWater srw = new SwiminRisingWater();
        int[][] grid = new int[][]{{0, 2}, {1, 3}};
        System.out.println(srw.swimInWater(grid));
    }
}
