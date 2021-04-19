
public class CombinationSumIV {

    private int count = 0;

    public int combinationSum4(int[] nums, int target) {
        backtracking(nums, target);
        return this.count;
    }

    private void backtracking(int[] nums, int target) {
        if (target == 0) {
            this.count++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                backtracking(nums, target - nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIV cs = new CombinationSumIV();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(cs.combinationSum4(nums, 4));
    }
}
