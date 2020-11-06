
public class FindtheSmallestDivisorGivenaThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        for (int i = 1; i < 1000000; i++) {
            int result = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % i == 0) {
                    result += nums[j] / i;
                } else {
                    result += (nums[j] / i + 1);
                }
            }
            if (result <= threshold) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        FindtheSmallestDivisorGivenaThreshold fsdgt = new FindtheSmallestDivisorGivenaThreshold();
        int[] nums = new int[]{1, 2, 5, 9};
        System.out.println(fsdgt.smallestDivisor(nums, 6));
    }
}
