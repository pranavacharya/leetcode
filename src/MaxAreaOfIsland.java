
public class MaxAreaOfIsland {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int maxArea;

    public int maxAreaOfIsland(int[][] grid) {
        this.maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, helper(grid, i, j));
                }
            }
        }
        return this.maxArea;
    }

    private int helper(int[][] grid, int row, int col) {
        int area = 1;
        grid[row][col] = 0;
        for (int[] dir : dirs) {
            int row1 = row + dir[0];
            int col1 = col + dir[1];
            if (row1 >= 0 && row1 < grid.length
                    && col1 >= 0 && col1 < grid[row1].length
                    && grid[row1][col1] == 1) {
                area += helper(grid, row1, col1);
            }
        }
        return area;
    }

    public static void main(String args[]) {
        int[][] grid = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        MaxAreaOfIsland maoi = new MaxAreaOfIsland();
        System.out.println(maoi.maxAreaOfIsland(grid));
    }
}
