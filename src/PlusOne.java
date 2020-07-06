
import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digits[i]++;
            }
            digits[i] += carry;
            carry = 0;
            if (digits[i] > 9) {
                digits[i] = digits[i] % 10;
                carry = 1;
            }
            if (carry == 0) {
                break;
            }
        }
        if (carry == 1) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            int index = 1;
            for (int d : digits) {
                ans[index++] = d;
            }
            return ans;
        }
        return digits;
    }

    public static void main(String args[]) {
        PlusOne po = new PlusOne();
        int[] digits = new int[]{9, 2, 3, 9, 9};
        System.out.println(Arrays.toString(po.plusOne(digits)));
    }
}
