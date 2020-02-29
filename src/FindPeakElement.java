
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        FindPeakElement fpe = new FindPeakElement();
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(fpe.findPeakElement(nums));
    }
}
