
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int cur_max = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur_max = Math.max(nums[i], cur_max + nums[i]);
            max = Math.max(max, cur_max);
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(ms.maxSubArray(nums));
    }
}
