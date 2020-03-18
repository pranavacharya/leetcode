
import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        digits = reverse(digits);
        boolean added = false;
        for (int i = 0; i < digits.length; i++) {
            if (!added) {
                if (digits[i] < 9) {
                    digits[i]++;
                    added = true;
                } else {
                    digits[i] = 0;
                }
            }
        }
        if (!added) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            return reverse(digits);
        }
    }

    public int[] reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }

    public static void main(String args[]) {
        PlusOne po = new PlusOne();
        int[] digits = new int[]{9, 2, 3, 9, 9};
        System.out.println(Arrays.toString(po.plusOne(digits)));
    }
}
