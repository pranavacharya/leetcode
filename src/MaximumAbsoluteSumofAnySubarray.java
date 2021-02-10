
public class MaximumAbsoluteSumofAnySubarray {

    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int min = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }

        sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum = 0;
            }
            sum += nums[i];
            min = Math.min(min, sum);
        }

        return Math.max(Math.abs(max), Math.abs(min));
    }

    public static void main(String args[]) {
        MaximumAbsoluteSumofAnySubarray masss = new MaximumAbsoluteSumofAnySubarray();
        int[] nums = new int[]{1, -3, 2, 3, -4};
        System.out.println(masss.maxAbsoluteSum(nums));
    }
}
