
public class MinimumOperationstoReduceXtoZero {

    public int minOperations(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (left <= right && sum + nums[left] <= x) {
            sum += nums[left];
            left++;
        }
        if (sum == x) {
            min = left;
        }
        while (left <= right && left >= 0) {
            while (sum + nums[right] <= x) {
                sum += nums[right];
                right--;
            }
            if (sum == x) {
                min = Math.min(min, left + nums.length - 1 - right);
            }
            left--;
            if (left >= 0) {
                sum -= nums[left];
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String args[]) {
        MinimumOperationstoReduceXtoZero morz = new MinimumOperationstoReduceXtoZero();
        int[] nums = new int[]{1000, 1, 1, 2, 3};
        System.out.println(morz.minOperations(nums, 1004));
    }
}
