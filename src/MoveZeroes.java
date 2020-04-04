
import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String args[]) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
    }
}
