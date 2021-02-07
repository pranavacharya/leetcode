
public class CheckifArrayIsSortedandRotated {

    public boolean check(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int i = 1;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }
        if (i == nums.length) {
            return true;
        }
        for (i = i + 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        if (nums[i - 1] > nums[0]) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        CheckifArrayIsSortedandRotated casr = new CheckifArrayIsSortedandRotated();
        int[] nums = new int[]{2, 1, 3, 4};
        System.out.println(casr.check(nums));
    }
}
