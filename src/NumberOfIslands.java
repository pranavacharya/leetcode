
public class NumberOfIslands {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '#';

        for (int[] dir : dirs) {
            int nx = dir[0] + x;
            int ny = dir[1] + y;

            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[nx].length) {
                dfs(grid, nx, ny);
            }
        }
    }

    public static void main(String args[]) {
        NumberOfIslands noi = new NumberOfIslands();
        char[][] grid = new char[][]{{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'},
        {'1', '1', '1', '0', '1'}};
        System.out.println(noi.numIslands(grid));
    }
}
