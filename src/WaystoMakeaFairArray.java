
import java.util.Arrays;

public class WaystoMakeaFairArray {

    public int waysToMakeFair(int[] nums) {
        int[] suff = new int[nums.length + 1];
        int sum = 0;
        for (int i = suff.length - 2; i >= 0; i = i - 2) {
            suff[i] = sum + nums[i];
            sum = suff[i];
        }
        sum = 0;
        for (int i = suff.length - 3; i >= 0; i = i - 2) {
            suff[i] = sum + nums[i];
            sum = suff[i];
        }
        int odd = suff[0];
        int even = suff[1];
        int count = 0;
        System.out.println(Arrays.toString(suff));
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1) % 2 == 0) {
                int newEven = even - suff[i] + suff[i + 1];
                int newOdd = odd - suff[i + 1] + (suff[i] - nums[i]);
                if (newEven == newOdd) {
                    count++;
                }
            } else {
                int newOdd = odd - suff[i] + suff[i + 1];
                int newEven = even - suff[i + 1] + (suff[i] - nums[i]);
                if (newEven == newOdd) {
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String args[]) {
        WaystoMakeaFairArray wmfa = new WaystoMakeaFairArray();
        int[] nums = new int[]{2, 1, 6, 4};
        System.out.println(wmfa.waysToMakeFair(nums));
    }
}
