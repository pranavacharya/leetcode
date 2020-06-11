
import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        int[] frequency = new int[3];
        for (int i : nums) {
            frequency[i]++;
        }
        int index = 0;
        while (frequency[0] > 0) {
            nums[index] = 0;
            frequency[0]--;
            index++;
        }
        while (frequency[1] > 0) {
            nums[index] = 1;
            frequency[1]--;
            index++;
        }
        while (frequency[2] > 0) {
            nums[index] = 2;
            frequency[2]--;
            index++;
        }
    }

    public static void main(String args[]) {
        SortColors sc = new SortColors();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
