
public class TargetSum {

    private int combination;

    public int findTargetSumWays(int[] nums, int S) {
        this.combination = 0;
        backtracking(nums, S, 0, 0);
        return this.combination;
    }

    private void backtracking(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (target == sum) {
                this.combination++;
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                backtracking(nums, target, index + 1, sum + nums[index]);
            } else {
                backtracking(nums, target, index + 1, sum - nums[index]);
            }
        }
    }

    public static void main(String args[]) {
        TargetSum ts = new TargetSum();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(ts.findTargetSumWays(nums, 5));
    }
}
