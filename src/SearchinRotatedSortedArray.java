
public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int pivot = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        pivot = left;
        int low = 0;
        int high = nums.length - 1;
        if (target >= nums[pivot] && target <= nums[high]) {
            low = pivot;
        } else {
            high = pivot - 1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(srsa.search(nums, 1));
    }
}
