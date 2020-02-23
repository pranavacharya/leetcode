
import java.util.ArrayList;
import java.util.Arrays;

public class LargestMultipleOfThree {

    private ArrayList<String> list = new ArrayList<>();

    public String largestMultipleOfThree(int[] digits) {
        String number = "";
        for (int i = 0; i < digits.length; i++) {
            number = number + digits[i];
        }
        subset("", number);
        int max = Integer.MIN_VALUE;
        for (String i : list) {
            if (Integer.parseInt(i) > max) {
                max = Integer.parseInt(i);
            }
        }
        if (max == Integer.MIN_VALUE) {
            return "";
        }
        char[] res = Integer.toString(max).toCharArray();
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
                this.list.add(soFar);
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

    public static void main(String args[]) {
        LargestMultipleOfThree lmot = new LargestMultipleOfThree();
        int[] arr = new int[]{7, 8, 7, 2, 1, 2, 6, 6, 9, 2};
        System.out.println(lmot.largestMultipleOfThree(arr));
    }
}
