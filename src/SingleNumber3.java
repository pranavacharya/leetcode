
import java.util.Arrays;

public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        xor = xor & ~(xor - 1);
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & xor) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String args[]) {
        SingleNumber3 sn3 = new SingleNumber3();
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(sn3.singleNumber(nums)));
    }
}
