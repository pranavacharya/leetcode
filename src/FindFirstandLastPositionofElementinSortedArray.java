
import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] ans = new int[]{-1, -1};
        int index = lowerBound(nums, target);
        if (index == nums.length || nums[index] != target) {
            return ans;
        }
        ans[0] = index;
        ans[1] = upperBound(nums, target) - 1;
        return ans;
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
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        FindFirstandLastPositionofElementinSortedArray fflpesa = new FindFirstandLastPositionofElementinSortedArray();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(fflpesa.searchRange(nums, 10)));
    }
}
