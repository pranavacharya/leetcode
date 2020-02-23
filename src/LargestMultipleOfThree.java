
import java.util.Arrays;

public class LargestMultipleOfThree {

    String ans = "";

    public String largestMultipleOfThree(int[] digits) {
        String number = "";
        for (int i = 0; i < digits.length; i++) {
            number = number + digits[i];
        }
        subset("", number);
        char[] res = this.ans.toCharArray();
        Arrays.sort(res);
        for (int i = 0; i < res.length / 2; i++) {
            char temp = res[i];
            res[i] = res[res.length - i - 1];
            res[res.length - i - 1] = temp;
        }
        return new String(res);
    }

    public void subset(String soFar, String rem) {
        if (rem.isEmpty()) {
            if (!soFar.isBlank() && isDivisibleby3(soFar)) {
                if (this.ans.length() < soFar.length()) {
                    this.ans = soFar;
                } else if (this.ans.length() == soFar.length()) {
                    this.ans = compareString(soFar);
                }
            }
        } else {
            String letter = rem.substring(0, 1);
            subset(soFar.concat(letter), rem.substring(1, rem.length()));
            subset(soFar, rem.substring(1, rem.length()));
        }
    }

    public boolean isDivisibleby3(String s) {
        int sum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            sum = sum + Character.getNumericValue(arr[i]);
        }
        return (sum % 3 == 0);
    }

    public String compareString(String s) {
        char[] current = this.ans.toCharArray();
        char[] input = s.toCharArray();
        Arrays.sort(current);
        Arrays.sort(input);
        for (int i = current.length - 1; i >= 0; i--) {
            if (input[i] > current[i]) {
                return new String(input);
            }
        }
        return new String(current);
    }

    public static void main(String args[]) {
        LargestMultipleOfThree lmot = new LargestMultipleOfThree();
        int[] arr = new int[]{6, 0, 8, 2, 6, 3, 5, 8, 6, 3, 0, 9, 8, 0, 8, 5, 4, 5, 1, 6, 9, 3, 0, 4, 7, 4, 3, 7, 8, 2, 6, 8, 3, 3, 7, 9, 2, 6, 6, 9, 9, 7, 8, 3, 5, 9, 8, 1, 1, 2, 9, 8, 8, 3, 8, 1, 9, 5, 3, 1, 7, 2, 0, 0, 4, 5, 0, 1, 3, 5, 8, 8, 4, 4, 0, 7, 5, 2, 4, 3, 6, 7, 5, 8, 6, 6, 8, 3, 4, 1, 3, 9, 0, 7, 3, 1, 1, 9, 3, 7, 2, 6, 7, 6, 4, 5, 6, 1, 5, 0, 6, 0, 6, 0, 7, 4, 6, 4, 2, 6, 3, 1, 4, 6, 8, 6, 0, 2, 1, 8, 5, 2, 9, 7, 9, 6, 3, 2, 2, 9, 3, 7, 1, 9, 7, 3, 3, 7, 6, 4, 6, 1, 8, 8, 5, 6, 6, 8, 7, 1, 5, 0, 7, 2, 2, 9, 4, 0, 7, 5, 3, 5, 8, 1, 1, 5, 8, 8, 2, 4, 1, 6, 8, 0, 5, 5, 7, 0, 2, 8, 9, 9, 9, 3, 8, 3, 2, 2, 9, 3, 1, 1, 7, 3, 2, 3, 9, 6, 6, 1, 3, 7, 4, 7, 6, 7, 5, 4, 5, 0, 7, 7, 4, 9, 5, 8, 5, 6, 1, 6, 1, 6, 9, 9, 3, 4, 4, 8, 6, 7, 1, 8, 2, 7, 7, 4, 3, 9, 7, 9, 4, 8, 3, 6, 2, 0, 2, 1, 3, 8, 7, 7, 6, 4, 8, 3, 6, 9, 8, 1, 3, 3, 6, 3, 6, 8, 5, 3, 4, 8, 3, 3, 5, 3, 8, 7, 0, 1, 9, 1, 2, 1, 2, 9, 9, 9, 2, 1, 5, 6, 4, 4, 9, 3, 1, 0, 3, 0, 0, 5, 8, 5, 5, 4, 6, 6, 5, 4, 7, 4, 1, 4, 7, 0, 7, 1, 6, 4, 5, 0, 8, 2, 9, 3, 1, 7, 7, 9, 9, 2, 5, 6, 6, 8, 2, 9, 5, 8, 4, 5, 6, 3, 5, 2, 7, 7, 2, 1, 3, 2, 2, 7, 9, 8, 7, 7, 4, 4, 5, 1, 6, 1, 8, 9, 3, 0, 4, 6, 3, 5, 4, 1, 0, 8, 9, 6, 9, 8, 0, 2, 9, 1, 6, 7, 1, 0, 8, 7, 5, 4, 0, 5, 6, 9, 5, 7, 1, 5, 2, 1, 5, 9, 2, 5, 6, 9, 8, 9, 3, 7, 3, 3, 6, 5, 9, 3, 8, 2, 9, 4, 6, 9, 5, 7, 8, 0, 6, 3, 4, 5, 8, 6, 4, 1, 8, 8, 9, 3, 2, 0, 4, 2, 1, 9, 6, 7, 7, 2, 9, 2, 8, 2, 6, 2, 1, 3, 8, 5, 1, 6, 2, 0, 7, 2, 8, 1, 0, 2, 2, 5, 9, 5, 8, 2, 5, 1, 2, 3, 9, 4, 8, 9, 8, 9, 3, 4, 3, 4, 4, 3};
        System.out.println(lmot.largestMultipleOfThree(arr));
    }
}
