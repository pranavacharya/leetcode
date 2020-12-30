
import java.util.Arrays;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int[] freq = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
            if (freq[nums[i]] > 1) {
                ans[0] = nums[i];
            }
        }

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        SetMismatch sm = new SetMismatch();
        int[] nums = new int[]{1, 2, 2, 4};
        System.out.println(Arrays.toString(sm.findErrorNums(nums)));
    }
}
