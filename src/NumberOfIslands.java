
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                dfs(grid, x, y);
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
