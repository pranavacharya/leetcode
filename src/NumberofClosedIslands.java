
public class NumberofClosedIslands {

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j, grid.length, 0, grid[i].length, 0)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int i, int j, int t, int b, int l, int r) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        } else if (grid[i][j] == 1) {
            return true;
        } else {
            grid[i][j] = 1;
            t = Math.min(t, i);
            b = Math.max(b, i);
            l = Math.min(l, j);
            r = Math.max(r, j);
            //top
            boolean top = dfs(grid, i - 1, j, t, b, l, r);
            //bottom
            boolean bottom = dfs(grid, i + 1, j, t, b, l, r);
            //left
            boolean left = dfs(grid, i, j - 1, t, b, l, r);
            //right
            boolean right = dfs(grid, i, j + 1, t, b, l, r);
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
