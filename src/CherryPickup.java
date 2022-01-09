
public class CherryPickup {

    private int[][][][] dp;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        this.dp = new int[n][n][n][n];
        int ans = helper(grid, 0, 0, 0, 0);
        return ans < 0 ? 0 : ans;
    }

    private int helper(int[][] grid, int x1, int y1, int x2, int y2) {
        if (x1 < 0 || x1 > grid.length - 1 || y1 < 0 || y1 > grid.length - 1
                || x2 < 0 || x2 > grid.length - 1 || y2 < 0 || y2 > grid.length - 1
                || grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return Integer.MIN_VALUE;
        };

        if (x1 == grid.length - 1 && y1 == grid[0].length - 1) {
            return grid[x1][y1];
        }

        if (this.dp[x1][y1][x2][y2] != 0) {
            return this.dp[x1][y1][x2][y2];
        }

        int cherries = 0;
        if (x1 == x2 && y1 == y2) {
            cherries += grid[x1][y1];
        } else {
            cherries += grid[x1][y1];
            cherries += grid[x2][y2];
        }

        int f1 = helper(grid, x1 + 1, y1, x2 + 1, y2);
        int f2 = helper(grid, x1 + 1, y1, x2, y2 + 1);
        int f3 = helper(grid, x1, y1 + 1, x2 + 1, y2);
        int f4 = helper(grid, x1, y1 + 1, x2, y2 + 1);

        cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));

        return this.dp[x1][y1][x2][y2] = cherries;
    }

    public static void main(String[] args) {
        CherryPickup cp = new CherryPickup();
        int[][] grid = new int[][]{
            {1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1}};
//        int[][] grid = new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}};
//        int[][] grid = new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        System.out.println(cp.cherryPickup(grid));
    }
}
