
public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch bs = new BinarySearch();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(bs.search(nums, 9));
    }
}
