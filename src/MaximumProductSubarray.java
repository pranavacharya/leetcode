
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // swap
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);

            ans = Math.max(ans, max);
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(mps.maxProduct(nums));
    }
}
