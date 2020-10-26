
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 2][query_row + 2];
        dp[1][1] = poured;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (dp[i - 1][j - 1] > 1) {
                    dp[i][j] += ((dp[i - 1][j - 1] - 1) / 2);
                }
                if (dp[i - 1][j] > 1) {
                    dp[i][j] += ((dp[i - 1][j] - 1) / 2);
                }
            }
        }
        return dp[query_row + 1][query_glass + 1] > 1 ? 1 : dp[query_row + 1][query_glass + 1];
    }

    public static void main(String args[]) {
        ChampagneTower ct = new ChampagneTower();
        System.out.println(ct.champagneTower(1, 1, 1));
        System.out.println(ct.champagneTower(2, 1, 1));
        System.out.println(ct.champagneTower(50, 2, 2));
    }
}
