
import java.util.Arrays;

public class MaximumXORforEachQuery {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ nums[i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[n - 1 - i] = findK(prefix[i], maximumBit);
        }
        return ans;
    }

    private int findK(int value, int maxBit) {
        int k = 0;
        int count = 0;
        while (maxBit > 0) {
            if ((value & 1) != 1) {
                // 1
                k = k | 1 << count++;
            } else {
                // 0
                k = k | 0 << count++;
            }
            value = value >> 1;
            maxBit--;
        }
        return k;
    }

    public static void main(String[] args) {
        MaximumXORforEachQuery mxeq = new MaximumXORforEachQuery();
        int[] nums = new int[]{0, 1, 1, 3};
        System.out.println(Arrays.toString(mxeq.getMaximumXor(nums, 2)));
    }
}
