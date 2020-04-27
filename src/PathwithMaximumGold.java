
public class PathwithMaximumGold {

    private int max;

    public PathwithMaximumGold() {
        this.max = 0;
    }

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    explorePath(grid, i, j, 0);
                }
            }
        }
        return this.max;
    }

    public void explorePath(int[][] grid, int i, int j, int sum) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] < 0) {
            return;
        } else if (grid[i][j] == 0) {
            this.max = Math.max(this.max, sum);
        } else {
            int gold = grid[i][j];
            sum += gold;
            grid[i][j] = -1;
            //top
            explorePath(grid, i - 1, j, sum);
            //bottom
            explorePath(grid, i + 1, j, sum);
            //left
            explorePath(grid, i, j - 1, sum);
            //right
            explorePath(grid, i, j + 1, sum);

            grid[i][j] = gold;
        }
    }

    public static void main(String args[]) {
        PathwithMaximumGold pwmg = new PathwithMaximumGold();
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(pwmg.getMaximumGold(grid));
    }
}
