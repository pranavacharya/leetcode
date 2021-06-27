
public class MaximumProductDifferenceBetweenTwoPairs {

    public int maxProductDifference(int[] nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] * nums[j]);
                min = Math.min(min, nums[i] * nums[j]);
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        MaximumProductDifferenceBetweenTwoPairs mpdbtp = new MaximumProductDifferenceBetweenTwoPairs();
        int[] nums = new int[]{5, 6, 2, 7, 4};
        System.out.println(mpdbtp.maxProductDifference(nums));
    }
}
