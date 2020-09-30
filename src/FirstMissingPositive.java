
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length || nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length + 1) {
                int index = Math.abs(nums[i]) - 1;
                if (index >= nums.length) {
                    continue;
                }
                if (nums[index] > 0) {
                    nums[index] = -1 * nums[index];
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String args[]) {
        FirstMissingPositive pmp = new FirstMissingPositive();
        int[] nums = new int[]{7, 8, 9, 11, 12};
        System.out.println(pmp.firstMissingPositive(nums));
    }
}
