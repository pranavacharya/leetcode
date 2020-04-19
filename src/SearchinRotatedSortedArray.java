
import java.util.ArrayList;

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int pivot = 0;
        while (pivot < nums.length - 1 && nums[pivot] < nums[pivot + 1]) {
            pivot++;
        }
        for (int i = pivot + 1; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i <= pivot && i < nums.length; i++) {
            list.add(nums[i]);
        }
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == target) {
                return (mid + pivot + 1) % nums.length;
            } else if (list.get(mid) < target) {
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
