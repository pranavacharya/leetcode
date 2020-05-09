
public class NumberofClosedIslands {

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        } else if (grid[i][j] == 1) {
            return true;
        } else {
            grid[i][j] = 1;
            //top
            boolean top = dfs(grid, i - 1, j);
            //bottom
            boolean bottom = dfs(grid, i + 1, j);
            //left
            boolean left = dfs(grid, i, j - 1);
            //right
            boolean right = dfs(grid, i, j + 1);
            return top && bottom && left && right;
        }
    }

    public static void main(String args[]) {
        NumberofClosedIslands noci = new NumberofClosedIslands();
        int[][] grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0},
        {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(noci.closedIsland(grid));
    }
}
