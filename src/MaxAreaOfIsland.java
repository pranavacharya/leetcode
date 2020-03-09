
public class MaxAreaOfIsland {

    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int maxArea = 0;
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                if (this.grid[i][j] == 1) {
                    int localArea = dfs(i, j);
                    maxArea = Math.max(maxArea, localArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int i, int j) {
        if (i >= 0 && i < this.grid.length && j >= 0 && j < this.grid[i].length) {
            if (this.grid[i][j] == 1) {
                this.grid[i][j] = 0;
                int ans = 1;
                ans += dfs(i + 1, j);
                ans += dfs(i, j + 1);
                ans += dfs(i - 1, j);
                ans += dfs(i, j - 1);
                return ans;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public static void main(String args[]) {
        int[][] grid = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        MaxAreaOfIsland maoi = new MaxAreaOfIsland();
        System.out.println(maoi.maxAreaOfIsland(grid));
    }
}
