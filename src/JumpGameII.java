
import java.util.Arrays;

public class JumpGameII {

    private int[] dp;

    public int jump(int[] nums) {
        this.dp = new int[nums.length];
        Arrays.fill(this.dp, - 1);
        return helper(0, nums);
    }

    private int helper(int index, int[] nums) {
        if (index >= nums.length - 1) {
            return 0;
        }
        if (this.dp[index] != -1) {
            return this.dp[index];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            min = Math.min(min, helper(index + i, nums));
        }
        return this.dp[index] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
    }

    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jg.jump(nums));
    }
}
