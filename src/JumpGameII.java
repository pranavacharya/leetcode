
import java.util.Arrays;

public class JumpGameII {

    private int[] dp;

    public int jump(int[] nums) {
        this.dp = new int[nums.length];
        Arrays.fill(this.dp, -1);
        return helper(0, nums);
    }

    private int helper(int i, int[] nums) {
        if (i == nums.length - 1) {
            return 0;
        }
        if (this.dp[i] != -1) {
            return this.dp[i];
        }
        int min = Integer.MAX_VALUE;
        int val = nums[i];
        for (int j = 1; i + j < nums.length && j <= val; j++) {
            min = Math.min(min, helper(i + j, nums));
        }
        return this.dp[i] = min == Integer.MAX_VALUE ? min : min + 1;
    }

    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jg.jump(nums));
    }
}
