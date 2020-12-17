
import java.util.Arrays;

public class SumofAbsoluteDifferencesinaSortedArray {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int total = 0;
        int[] suff = new int[n];
        for (int i = 0; i < n; i++) {
            total += nums[i];
            suff[i] = total;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            result[i] = total - 2 * suff[i] + num * (i + 1) - (n - i - 1) * num;
        }
        return result;
    }

    public static void main(String args[]) {
        SumofAbsoluteDifferencesinaSortedArray sadsa = new SumofAbsoluteDifferencesinaSortedArray();
        int[] nums = new int[]{2, 3, 5};
        System.out.println(Arrays.toString(sadsa.getSumAbsoluteDifferences(nums)));
    }
}
