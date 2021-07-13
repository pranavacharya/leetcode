
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        FindPeakElement fpe = new FindPeakElement();
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(fpe.findPeakElement(nums));
    }
}
