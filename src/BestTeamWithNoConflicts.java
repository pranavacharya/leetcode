
import java.util.Arrays;

public class BestTeamWithNoConflicts {

    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[scores.length];
        dp[0] = arr[0][1];
        for (int i = 1; i < dp.length; i++) {
            int max = arr[i][1];
            for (int j = 0; j < i; j++) {
                if (arr[i][1] >= arr[j][1]) {
                    max = Math.max(dp[j] + arr[i][1], max);
                }
            }
            dp[i] = max;
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String args[]) {
        BestTeamWithNoConflicts btwnc = new BestTeamWithNoConflicts();
        int[] scores = new int[]{4, 5, 6, 5};
        int[] ages = new int[]{2, 1, 2, 1};
        System.out.println(btwnc.bestTeamScore(scores, ages));
    }
}
