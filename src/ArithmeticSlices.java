
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            ans += dp[i];
        }
        return ans;
    }

    public static void main(String args[]) {
        ArithmeticSlices as = new ArithmeticSlices();
        int[] A = new int[]{1, 2, 3};
        System.out.println(as.numberOfArithmeticSlices(A));
    }
}
