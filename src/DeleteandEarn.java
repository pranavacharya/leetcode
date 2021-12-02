
public class DeleteandEarn {

    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        int[] dp = new int[10001];
        dp[0] = freq[0] * 0;
        dp[1] = freq[1] * 1;
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 1], freq[i] * i + dp[i - 2]);
        }
        return dp[10000];
    }

    public static void main(String[] args) {
        DeleteandEarn de = new DeleteandEarn();
        int[] nums = new int[]{3, 4, 2};
//        int[] nums = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println(de.deleteAndEarn(nums));
    }
}
