
public class RangeSumQuery {

    private int[] dp;

    public RangeSumQuery(int[] nums) {
        this.dp = new int[nums.length];
        for (int i = 0; i < this.dp.length; i++) {
            if (i == 0) {
                this.dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        int min = i == 0 ? 0 : dp[i - 1];
        return this.dp[j] - min;
    }

    public static void main(String args[]) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        RangeSumQuery rsq = new RangeSumQuery(nums);
        System.out.println(rsq.sumRange(0, 2));
        System.out.println(rsq.sumRange(2, 5));
        System.out.println(rsq.sumRange(0, 5));
    }
}
