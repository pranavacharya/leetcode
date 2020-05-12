
public class SingleElementinaSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 != 0) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                high = mid - 1;
            } else {
                low = mid + 2;
            }
        }
        return nums[low];
    }

    public static void main(String args[]) {
        SingleElementinaSortedArray seisa = new SingleElementinaSortedArray();
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(seisa.singleNonDuplicate(nums));
    }
}
