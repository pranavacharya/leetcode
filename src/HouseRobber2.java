
public class HouseRobber2 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int ans = dp[dp.length - 1];
        dp = new int[nums.length - 1];
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + 1]);
        }
        ans = Math.max(ans, dp[dp.length - 1]);
        return ans;
    }

    public static void main(String args[]) {
        HouseRobber2 hr2 = new HouseRobber2();
        int[] nums = new int[]{1, 3, 1, 3, 100};
        System.out.println(hr2.rob(nums));
    }
}
