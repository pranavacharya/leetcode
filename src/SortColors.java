
import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        for (int k = 0; k < nums.length && k <= j;) {
            if (nums[k] == 0) {
                swap(nums, i, k);
                if (i == k) {
                    k++;
                }
                i++;
            } else if (nums[k] == 2) {
                swap(nums, j, k);
                j--;
            } else {
                k++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) {
        SortColors sc = new SortColors();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
