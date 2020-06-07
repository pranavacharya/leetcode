
import java.util.Arrays;

public class ShuffletheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0, k = 0; i < n; i++, k = k + 2) {
            int j = i + n;
            result[k] = nums[i];
            result[k + 1] = nums[j];
        }
        return result;
    }

    public static void main(String args[]) {
        ShuffletheArray sta = new ShuffletheArray();
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        System.out.println(Arrays.toString(sta.shuffle(nums, 3)));
    }
}
