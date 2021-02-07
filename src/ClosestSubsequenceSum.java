
public class ClosestSubsequenceSum {

    private int minDiff;

    public int minAbsDifference(int[] nums, int goal) {
        this.minDiff = Integer.MAX_VALUE;
        backtracking(nums, 0, goal, 0);
        return this.minDiff;
    }

    private void backtracking(int[] nums, int index, int goal, int sum) {
        if (index == nums.length) {
            this.minDiff = Math.min(this.minDiff, Math.abs(sum - goal));
            return;
        }
        backtracking(nums, index + 1, goal, sum + nums[index]);
        backtracking(nums, index + 1, goal, sum);
    }

    public static void main(String args[]) {
        ClosestSubsequenceSum css = new ClosestSubsequenceSum();
        int[] nums = new int[]{5, -7, 3, 5};
        System.out.println(css.minAbsDifference(nums, 6));
    }
}
