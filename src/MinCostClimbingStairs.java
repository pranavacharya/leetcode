
import java.util.Arrays;

public class MinCostClimbingStairs {

    private int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        this.dp = new int[cost.length];
        Arrays.fill(this.dp, -1);
        return Math.min(helper(0, cost), helper(1, cost));
    }

    private int helper(int index, int[] cost) {
        if (index >= cost.length) {
            return 0;
        }
        if (this.dp[index] != -1) {
            return this.dp[index];
        }
        return this.dp[index] = Math.min(helper(index + 1, cost), helper(index + 2, cost)) + cost[index];
    }

    public static void main(String args[]) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(mccs.minCostClimbingStairs(cost));
    }
}
