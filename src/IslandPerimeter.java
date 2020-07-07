
public class IslandPerimeter {

    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        OUTER:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter = dfs(grid, i, j);
                    break OUTER;
                }
            }
        }
        return perimeter;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) {
            return 1;
        } else {
            int sum = 0;
            grid[row][col] = -1;
            for (int[] d : dir) {
                if (row + d[0] < 0 || row + d[0] >= grid.length || col + d[1] < 0 || col + d[1] >= grid[row].length) {
                    sum++;
                }
                if (row + d[0] >= 0 && row + d[0] < grid.length && col + d[1] >= 0 && col + d[1] < grid[row].length && grid[row + d[0]][col + d[1]] != -1) {
                    sum += dfs(grid, row + d[0], col + d[1]);
                }
            }
            return sum;
        }
    }

    public static void main(String args[]) {
        IslandPerimeter ip = new IslandPerimeter();
        int[][] grid = new int[][]{
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}};
        System.out.println(ip.islandPerimeter(grid));
    }
}
