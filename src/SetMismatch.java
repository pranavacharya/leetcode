
import java.util.Arrays;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int[] temp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (temp[nums[i]] == 1) {
                ans[0] = nums[i];
            } else {
                temp[nums[i]] = 1;
            }
        }
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        SetMismatch sm = new SetMismatch();
        int[] nums = new int[]{3, 3, 1};
        System.out.println(Arrays.toString(sm.findErrorNums(nums)));
    }
}
