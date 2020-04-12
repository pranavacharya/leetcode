
public class RangeSumQuery {

    private int[][] dp;

    public RangeSumQuery(int[] nums) {
        this.dp = new int[nums.length][nums.length];
        for (int i = 0; i < this.dp.length; i++) {
            for (int j = i; j < this.dp.length; j++) {
                if (i == j) {
                    this.dp[i][j] = nums[j];
                } else {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        return this.dp[i][j];
    }

    public static void main(String args[]) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        RangeSumQuery rsq = new RangeSumQuery(nums);
        System.out.println(rsq.sumRange(0, 2));
        System.out.println(rsq.sumRange(2, 5));
        System.out.println(rsq.sumRange(0, 5));
    }
}
