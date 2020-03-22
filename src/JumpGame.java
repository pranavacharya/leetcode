
public class JumpGame {

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        if (nums[0] < 1 && nums.length > 1) {
            return false;
        }
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = false;
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && nums[j] >= (i - j)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String args[]) {
        JumpGame jg = new JumpGame();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jg.canJump(nums));
    }
}
