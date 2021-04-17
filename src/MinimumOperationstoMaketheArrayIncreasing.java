
public class MinimumOperationstoMaketheArrayIncreasing {

    public int minOperations(int[] nums) {
        int ops = 0;
        if (nums.length == 0) {
            return ops;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ops += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumOperationstoMaketheArrayIncreasing momai = new MinimumOperationstoMaketheArrayIncreasing();
        int[] nums = new int[]{1, 5, 2, 4, 1};
        System.out.println(momai.minOperations(nums));
    }
}
