
import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] ans = new int[2];
        if (binarySearch(nums, target)) {
            ans[0] = lowerBound(nums, target);
            ans[1] = upperBound(nums, target);
        } else {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }

    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    private int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2 + 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return high;
    }

    public static void main(String args[]) {
        FindFirstandLastPositionofElementinSortedArray fflpesa = new FindFirstandLastPositionofElementinSortedArray();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(fflpesa.searchRange(nums, 8)));
    }
}
