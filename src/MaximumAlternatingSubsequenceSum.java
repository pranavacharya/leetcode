
import java.util.Arrays;

public class MaximumAlternatingSubsequenceSum {

    private long[][] dp;

    public long maxAlternatingSum(int[] nums) {
        this.dp = new long[nums.length][2];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(nums, 0, 0);
    }

    private long helper(int[] nums, int index, int isTurn) {
        if (index == nums.length) {
            return 0;
        }
        if (this.dp[index][isTurn] != -1) {
            return this.dp[index][isTurn];
        }
        if (isTurn != 0) {
            return this.dp[index][isTurn] = Math.max(helper(nums, index + 1, 0) - nums[index], helper(nums, index + 1, 1));
        } else {
            return this.dp[index][isTurn] = Math.max(nums[index] + helper(nums, index + 1, 1), helper(nums, index + 1, 0));
        }
    }

    public static void main(String[] args) {
        MaximumAlternatingSubsequenceSum mabs = new MaximumAlternatingSubsequenceSum();
        int[] nums = new int[]{4, 2, 5, 3};
        System.out.println(mabs.maxAlternatingSum(nums));
    }
}


/*


 */
