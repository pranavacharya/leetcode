
public class MaximumScorefromPerformingMultiplicationOperations {

    private int[][] memo;
    private int m;
    private int n;
    private int[] nums;
    private int[] multipliers;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.m = multipliers.length;
        this.n = nums.length;
        this.nums = nums;
        this.multipliers = multipliers;
        this.memo = new int[m][m];
        return dp(0, 0);
    }

    private int dp(int left, int index) {
        if (index == this.m) {
            return 0;
        }

        if (memo[left][index] != 0) {
            return memo[left][index];
        }

        int pickLeft = dp(left + 1, index + 1) + nums[left] * multipliers[index];
        int pickRight = dp(left, index + 1) + nums[n - (index - left) - 1] * multipliers[index];

        return memo[left][index] = Math.max(pickLeft, pickRight);
    }

    public static void main(String[] args) {
        MaximumScorefromPerformingMultiplicationOperations mspmo
                = new MaximumScorefromPerformingMultiplicationOperations();
        int[] nums = new int[]{-5, -3, -3, -2, 7, 1};
        int[] multipliers = new int[]{-10, -5, 3, 4, 6};
        System.out.println(mspmo.maximumScore(nums, multipliers));
    }
}
