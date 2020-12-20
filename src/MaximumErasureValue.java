
import java.util.HashSet;

public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int max = 0;
        int sum = 0;
        HashSet<Integer> set = new HashSet();
        while (end < n) {
            if (!set.contains(nums[end])) {
                set.add(nums[end]);
                sum += nums[end];
                max = Math.max(max, sum);
                end++;
            } else {
                set.remove(nums[start]);
                sum -= nums[start];
                max = Math.max(max, sum);
                start++;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumErasureValue mev = new MaximumErasureValue();
        int[] nums = new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5};
        System.out.println(mev.maximumUniqueSubarray(nums));
    }
}
