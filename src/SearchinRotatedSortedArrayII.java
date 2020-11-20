
public class SearchinRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[high] || nums[mid] < nums[low]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > nums[low] || nums[mid] > nums[high]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = low + 1;
                }
            } else {
                low++;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        SearchinRotatedSortedArrayII srsa = new SearchinRotatedSortedArrayII();
        int[] nums = new int[]{1, 1, 1, 1, 1, 2, 1, 1, 1, 1};
        System.out.println(srsa.search(nums, 2));
    }
}
