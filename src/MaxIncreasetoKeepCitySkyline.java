
public class MaxIncreasetoKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int count = 0;
        int[] leftRight = new int[grid.length];
        int[] topBotton = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                leftRight[i] = Math.max(leftRight[i], grid[i][j]);
                topBotton[j] = Math.max(topBotton[j], grid[i][j]);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = Math.min(leftRight[i], topBotton[j]);
                count += min - grid[i][j];
            }
        }
        return count;
    }

    public static void main(String args[]) {
        MaxIncreasetoKeepCitySkyline mikcs = new MaxIncreasetoKeepCitySkyline();
        int[][] grid = new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(mikcs.maxIncreaseKeepingSkyline(grid));
    }
}
