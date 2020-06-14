
import java.util.Arrays;

public class RunningSumof1dArray {

    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public static void main(String args[]) {
        RunningSumof1dArray rsa = new RunningSumof1dArray();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(rsa.runningSum(nums)));
    }
}
