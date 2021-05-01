
import java.util.Arrays;

public class MaximumElementAfterDecreasingandRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            }
            arr[i] = arr[i - 1] + 1;
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        MaximumElementAfterDecreasingandRearranging meadr = new MaximumElementAfterDecreasingandRearranging();
        int[] arr = new int[]{100, 1, 1000};
        System.out.println(meadr.maximumElementAfterDecrementingAndRearranging(arr));
    }
}
