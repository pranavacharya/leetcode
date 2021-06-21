
public class SwiminRisingWater {

    private int max = Integer.MAX_VALUE;

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        helper(grid, 0, 0, new boolean[grid.length][grid[0].length], grid[0][0]);
        return this.max;
    }

    private void helper(int[][] grid, int i, int j, boolean[][] visited, int max) {
        // System.out.println("i " + i + " j " + j);
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            this.max = Math.min(this.max, max);
            return;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && !visited[x][y]) {
                helper(grid, x, y, visited, Math.max(max, grid[x][y]));
            }
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        SwiminRisingWater srw = new SwiminRisingWater();
        int[][] grid = new int[][]{{0, 2}, {1, 3}};
        System.out.println(srw.swimInWater(grid));
    }
}
