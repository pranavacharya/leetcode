
public class JumpGameVI {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i - 1, c = k; j >= 0 && c > 0; j--, c--) {
                max = Math.max(max, nums[i] + dp[j]);
            }
            dp[i] = max;
        }
        return dp[n - 1];
    }

    public static void main(String args[]) {
        JumpGameVI jg = new JumpGameVI();
        int[] nums = new int[]{1, -5, -20, 4, -1, 3, -6, -3};
        System.out.println(jg.maxResult(nums, 2));
    }

}
