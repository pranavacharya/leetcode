
import java.util.Arrays;

public class RunningSumof1dArray {

    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }

    public static void main(String args[]) {
        RunningSumof1dArray rsa = new RunningSumof1dArray();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(rsa.runningSum(nums)));
    }
}
