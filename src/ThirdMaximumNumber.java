
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int index = -1;
        int max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max2 && nums[i] != max) {
                max2 = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max3 && nums[i] != max && nums[i] != max2) {
                index = i;
                max3 = nums[i];
            }
        }
        if (index == -1) {
            return max;
        }
        return nums[index];
    }

    public static void main(String args[]) {
        ThirdMaximumNumber tmn = new ThirdMaximumNumber();
        int[] nums = new int[]{1, 2, -2147483648};
        System.out.println(tmn.thirdMax(nums));
    }
}
