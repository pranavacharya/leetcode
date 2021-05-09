
public class MaximumSubarrayMinProduct {

    int mod = (int) 1e9 + 7;

    public int maxSumMinProduct(int[] nums) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long maxMinProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                long sum = prefix[j + 1] - prefix[i];
                long product = sum * min;
                maxMinProduct = Math.max(maxMinProduct, product);
            }
        }
        return (int) (maxMinProduct % mod);
    }

    public static void main(String[] args) {
        MaximumSubarrayMinProduct msmp = new MaximumSubarrayMinProduct();
        int[] nums = new int[]{2, 3, 3, 1, 2};
        System.out.println(msmp.maxSumMinProduct(nums));
    }
}
