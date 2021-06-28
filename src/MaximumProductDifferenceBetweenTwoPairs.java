
public class MaximumProductDifferenceBetweenTwoPairs {

    public int maxProductDifference(int[] nums) {
        int max = 0;
        int secondMax = 0;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }

            if (nums[i] < min) {
                secondMin = min;
                min = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }
        return max * secondMax - min * secondMin;
    }

    public static void main(String[] args) {
        MaximumProductDifferenceBetweenTwoPairs mpdbtp = new MaximumProductDifferenceBetweenTwoPairs();
        int[] nums = new int[]{5, 6, 2, 7, 4};
        System.out.println(mpdbtp.maxProductDifference(nums));
    }
}
