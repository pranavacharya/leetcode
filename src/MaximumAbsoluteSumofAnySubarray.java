
public class MaximumAbsoluteSumofAnySubarray {

    public int maxAbsoluteSum(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        int maxSum = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefix[j + 1] - prefix[i];
                maxSum = Math.max(maxSum, Math.abs(sum));
            }
        }
        return maxSum;
    }

    public static void main(String args[]) {
        MaximumAbsoluteSumofAnySubarray masss = new MaximumAbsoluteSumofAnySubarray();
        int[] nums = new int[]{1, -3, 2, 3, -4};
        System.out.println(masss.maxAbsoluteSum(nums));
    }
}
