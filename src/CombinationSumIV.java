
import java.util.Arrays;

public class CombinationSumIV {

    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        this.dp = new int[target + 1];
        Arrays.fill(this.dp, -1);
        return backtracking(nums, target);
    }

    private int backtracking(int[] nums, int target) {
        if (this.dp[target] != -1) {
            return this.dp[target];
        }
        if (target == 0) {
            return this.dp[target] = 1;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                ans += backtracking(nums, target - nums[i]);
            }
        }
        return this.dp[target] = ans;
    }

    public static void main(String[] args) {
        CombinationSumIV cs = new CombinationSumIV();
        int[] nums = new int[]{2, 1, 3};
        System.out.println(cs.combinationSum4(nums, 35));
    }
}
