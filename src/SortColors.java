
import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    public static void main(String args[]) {
        SortColors sc = new SortColors();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
