
import java.util.Arrays;

public class NumbersSmallerThanCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String args[]) {
        NumbersSmallerThanCurrentNumber nstcn = new NumbersSmallerThanCurrentNumber();
        int[] nums = new int[]{8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(nstcn.smallerNumbersThanCurrent(nums)));
    }
}
