
import java.util.Arrays;

public class SumofAbsoluteDifferencesinaSortedArray {

    public int[] getSumAbsoluteDifferences(int[] nums) {

        int[] diff = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = diff[i - 1] + nums[i] - nums[i - 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int total = 0;
            for (int j = 0; j < nums.length; j++) {
                total += Math.abs(diff[i] - diff[j]);
            }
            result[i] = total;
        }
        return result;
    }

    public static void main(String args[]) {
        SumofAbsoluteDifferencesinaSortedArray sadsa = new SumofAbsoluteDifferencesinaSortedArray();
        int[] nums = new int[]{2, 3, 5};
        System.out.println(Arrays.toString(sadsa.getSumAbsoluteDifferences(nums)));
    }
}
