
import java.util.Arrays;

public class MaximumGap {

    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumGap mg = new MaximumGap();
        int[] nums = new int[]{3, 6, 9, 1};
        System.out.println(mg.maximumGap(nums));
    }
}
