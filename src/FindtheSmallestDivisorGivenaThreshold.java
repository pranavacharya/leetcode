
public class FindtheSmallestDivisorGivenaThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 1000000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % mid == 0) {
                    result += nums[i] / mid;
                } else {
                    result += (nums[i] / mid + 1);
                }
            }
            if (result > threshold) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        FindtheSmallestDivisorGivenaThreshold fsdgt = new FindtheSmallestDivisorGivenaThreshold();
        int[] nums = new int[]{1, 2, 5, 9};
        System.out.println(fsdgt.smallestDivisor(nums, 6));
    }
}
