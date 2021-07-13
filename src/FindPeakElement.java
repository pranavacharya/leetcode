
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        FindPeakElement fpe = new FindPeakElement();
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(fpe.findPeakElement(nums));
    }
}
