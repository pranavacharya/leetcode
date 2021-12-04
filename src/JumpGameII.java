
import java.util.Arrays;

public class JumpGameII {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j > nums[j]) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jg.jump(nums));
    }
}
