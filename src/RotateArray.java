
import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            ans[index] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }

    public static void main(String args[]) {
        RotateArray ra = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ra.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
