
import java.util.Arrays;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String args[]) {
        TwoSum2 ts2 = new TwoSum2();
        int[] numbers = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(ts2.twoSum(numbers, 9)));
    }
}
