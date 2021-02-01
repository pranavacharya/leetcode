
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

    public static void main(String args[]) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
    }
}
