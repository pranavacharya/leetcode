
import java.util.Arrays;

public class MaximumPointsYouCanObtainfromCards {

    private int[][][] dp;

    public int maxScore(int[] cardPoints, int k) {
        this.dp = new int[cardPoints.length][cardPoints.length][k + 1];
        for (int i = 0; i < this.dp.length; i++) {
            for (int j = 0; j < this.dp[i].length; j++) {
                Arrays.fill(this.dp[i][j], -1);
            }
        }
        return helper(0, cardPoints.length - 1, k, cardPoints);
    }

    private int helper(int i, int j, int k, int[] cardPoints) {
        if (k == 0) {
            return 0;
        }
        if (this.dp[i][j][k] != -1) {
            return this.dp[i][j][k];
        }
        return this.dp[i][j][k] = Math.max(helper(i + 1, j, k - 1, cardPoints) + cardPoints[i], helper(i, j - 1, k - 1, cardPoints) + cardPoints[j]);
    }

    public static void main(String args[]) {
        MaximumPointsYouCanObtainfromCards mpycofc = new MaximumPointsYouCanObtainfromCards();
        int[] cardPoints = new int[]{1, 79, 80, 1, 1, 1, 200, 1};
        System.out.println(mpycofc.maxScore(cardPoints, 3));
    }
}
