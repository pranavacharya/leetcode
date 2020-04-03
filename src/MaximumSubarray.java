
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, calculateSum(i, j, nums));
            }
        }
        return max;
    }

    public int calculateSum(int i, int j, int[] arr) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }

    public static void main(String args[]) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(ms.maxSubArray(nums));
    }
}
