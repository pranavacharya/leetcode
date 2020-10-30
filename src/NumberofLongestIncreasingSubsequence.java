
public class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] pos = new int[nums.length];
        int ans = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            pos[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pos[i] = pos[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        pos[i] += pos[j];
                    }
                }
            }
            if (max == dp[i]) {
                ans += pos[i];
            }
            if (max < dp[i]) {
                max = dp[i];
                ans = pos[i];
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        NumberofLongestIncreasingSubsequence nlis = new NumberofLongestIncreasingSubsequence();
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(nlis.findNumberOfLIS(nums));
    }
}
