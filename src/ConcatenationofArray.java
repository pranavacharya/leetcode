
import java.util.Arrays;

public class ConcatenationofArray {

    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ConcatenationofArray ca = new ConcatenationofArray();
        int[] nums = new int[]{1, 2, 1};
        System.out.println(Arrays.toString(ca.getConcatenation(nums)));
    }
}
