
import java.util.Arrays;

public class MinimizeMaximumPairSuminArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(nums[i] + nums[nums.length - 1 - i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        MinimizeMaximumPairSuminArray mnpspa = new MinimizeMaximumPairSuminArray();
        int[] nums = new int[]{3, 5, 4, 2, 4, 6};
        System.out.println(mnpspa.minPairSum(nums));
    }
}
