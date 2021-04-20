
import java.util.Arrays;

public class PredicttheWinner {

    private int[][] dp;

    public boolean PredictTheWinner(int[] nums) {
        this.dp = new int[nums.length][nums.length];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(0, nums.length - 1, nums) >= 0;
    }

    private int helper(int i, int j, int[] nums) {
        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        if (i == j) {
            return this.dp[i][j] = nums[i];
        }

        return this.dp[i][j] = Math.max(nums[i] - helper(i + 1, j, nums), nums[j] - helper(i, j - 1, nums));

    }

    public static void main(String args[]) {
        PredicttheWinner pw = new PredicttheWinner();
        int[] nums = new int[]{1, 5, 233, 7};
        System.out.println(pw.PredictTheWinner(nums));
    }
}
