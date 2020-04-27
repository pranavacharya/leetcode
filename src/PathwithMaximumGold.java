
public class PathwithMaximumGold {

    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    int local = explorePath(grid, i, j, 0, 0);
                    max = Math.max(max, local);
                }
            }
        }
        return max;
    }

    public int explorePath(int[][] grid, int i, int j, int sum, int max) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] < 0) {
            return max;
        } else if (grid[i][j] == 0) {
            max = Math.max(max, sum);
            return max;
        } else {
            int gold = grid[i][j];
            sum += gold;
            grid[i][j] = -1;
            //top
            max = explorePath(grid, i - 1, j, sum, max);
            //bottom
            max = explorePath(grid, i + 1, j, sum, max);
            //left
            max = explorePath(grid, i, j - 1, sum, max);
            //right
            max = explorePath(grid, i, j + 1, sum, max);

            grid[i][j] = gold;
            return max;
        }
    }

    public static void main(String args[]) {
        PathwithMaximumGold pwmg = new PathwithMaximumGold();
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(pwmg.getMaximumGold(grid));
    }
}
