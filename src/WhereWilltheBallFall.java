
import java.util.Arrays;

public class WhereWilltheBallFall {

    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            ans[i] = willFall(grid, i);
        }
        return ans;
    }

    private int willFall(int[][] grid, int j) {
        int i = 0;
        while (i < grid.length) {
            if (j == 0 && grid[i][j] == -1) {
                return -1;
            }
            if (j == grid[0].length - 1 && grid[i][j] == 1) {
                return -1;
            }
            if (j + 1 < grid[0].length && grid[i][j] == 1 && grid[i][j + 1] == -1) {
                return -1;
            }
            if (j - 1 >= 0 && grid[i][j] == -1 && grid[i][j - 1] == 1) {
                return -1;
            }
            if (grid[i][j] == 1) {
                j++;
            } else {
                j--;
            }
            i++;
        }
        if (j < 0 && j >= grid[0].length) {
            return -1;
        }
        return j;
    }

    public static void main(String args[]) {
        WhereWilltheBallFall wwbf = new WhereWilltheBallFall();
        int[][] grid = new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1},
        {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        System.out.println(Arrays.toString(wwbf.findBall(grid)));
    }
}
