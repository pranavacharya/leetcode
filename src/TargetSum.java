
import java.util.Arrays;

public class TargetSum {

    int[][] dp;
    int total;

    public int findTargetSumWays(int[] nums, int target) {
        this.total = 0;
        for (int i = 0; i < nums.length; i++) {
            this.total += nums[i];
        }
        this.dp = new int[total + total + 1][nums.length];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        int ans = helper(nums, target, 0, 0);
        return ans;
    }

    private int helper(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        if (this.dp[sum + total][index] != -1) {
            return this.dp[sum + total][index];
        }

        int ans = 0;

        ans += helper(nums, target, index + 1, sum + nums[index]);

        ans += helper(nums, target, index + 1, sum - nums[index]);

        return this.dp[sum + total][index] = ans;
    }

    public static void main(String args[]) {
        TargetSum ts = new TargetSum();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(ts.findTargetSumWays(nums, 5));
    }
}
