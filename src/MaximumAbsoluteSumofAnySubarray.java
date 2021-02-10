
public class MaximumAbsoluteSumofAnySubarray {

    public int maxAbsoluteSum(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        int max = 0;
        int min = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
            max = Math.max(max, prefix[i]);
            min = Math.min(min, prefix[i]);
        }
        return Math.abs(max - min);
    }

    public static void main(String args[]) {
        MaximumAbsoluteSumofAnySubarray masss = new MaximumAbsoluteSumofAnySubarray();
        int[] nums = new int[]{1, -3, 2, 3, -4};
        System.out.println(masss.maxAbsoluteSum(nums));
    }
}
