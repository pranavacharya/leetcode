
import java.util.Arrays;

public class GridGame {

    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] prefix = new long[n];
        prefix[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + grid[0][i];
        }
        long[] suffix = new long[n + 1];
        suffix[n - 1] = grid[1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + grid[1][i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(prefix[n - 1] - prefix[i], suffix[0] - suffix[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        GridGame gg = new GridGame();
        int[][] grid = new int[][]{{20, 3, 20, 17, 2, 12, 15, 17, 4, 15}, {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}};
        System.out.println(gg.gridGame(grid));
    }
}
