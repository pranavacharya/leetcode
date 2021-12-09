
import java.util.Arrays;

public class ArithmeticSlices {

    private int[][] dp;

    public int numberOfArithmeticSlices(int[] nums) {
        this.dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int i, int j) {

        if (this.dp[i][j] != -1) {
            return 0; // not using previously counted
        }

        if (j - i + 1 < 3) {
            return this.dp[i][j] = 0;
        }

        boolean valid = true;

        for (int start = i + 1; start < j; start++) {
            if (nums[start] - nums[start - 1] != nums[start + 1] - nums[start]) {
                valid = false;
                break;
            }
        }

        int count = 0;

        for (int k = i; k < j; k++) {
            count += (helper(nums, i, k));
            count += (helper(nums, k + 1, j));
        }

        if (valid) {
            count++;
        }

        return this.dp[i][j] = count;

    }

    public static void main(String args[]) {
        ArithmeticSlices as = new ArithmeticSlices();
        int[] A = new int[]{1, 2, 3};
        System.out.println(as.numberOfArithmeticSlices(A));
    }
}
