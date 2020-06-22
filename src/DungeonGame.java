
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = Math.max(1 - dungeon[n - 1][m - 1], 1);

        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = Math.max(dp[i + 1][m - 1] - dungeon[i][m - 1], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1][i] = Math.max(dp[n - 1][i + 1] - dungeon[n - 1][i], 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]));
            }
        }

        return dp[0][0];
    }

    public static void main(String args[]) {
        DungeonGame dg = new DungeonGame();
        int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(dg.calculateMinimumHP(dungeon));
    }
}
