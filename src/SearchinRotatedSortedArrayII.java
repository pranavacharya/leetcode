
public class SearchinRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int pivot = findPivot(nums);
        if (target == nums[pivot]) {
            return true;
        }
        return binarySearch(nums, target, pivot, nums.length - 1) || binarySearch(nums, target, 0, pivot - 1);
    }

    private int findPivot(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    private boolean binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
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
