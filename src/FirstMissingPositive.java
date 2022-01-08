
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int non = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                non++;
            }
        }
        int valid = nums.length - non;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= valid) {
                int val = Math.abs(nums[i]);
                if (nums[val - 1] > 0) {
                    nums[val - 1] = nums[val - 1] * -1;
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
