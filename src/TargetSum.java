
public class TargetSum {

    int valid = 0;

    public int findTargetSumWays(int[] nums, int target) {
        helper(nums, target, 0);
        return this.valid;
    }

    private void helper(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                this.valid++;
            }
            return;
        }

        helper(nums, target - nums[index], index + 1);

        helper(nums, target + nums[index], index + 1);

    }

    public static void main(String args[]) {
        TargetSum ts = new TargetSum();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(ts.findTargetSumWays(nums, 5));
    }
}
