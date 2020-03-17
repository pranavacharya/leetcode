
import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size;) {
            if (nums[i] == 0) {
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[size - 1] = 0;
                size--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String args[]) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = new int[]{0, 0, 1};
        mz.moveZeroes(nums);
    }
}
