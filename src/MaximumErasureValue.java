
import java.util.HashSet;

public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int start = 0;
        int end = 0;
        HashSet<Integer> set = new HashSet();
        int localSum = nums[end];
        set.add(nums[end]);
        while (end < nums.length && start < nums.length) {
            while (end + 1 < nums.length && !set.contains(nums[end + 1])) {
                end++;
                set.add(nums[end]);
                localSum += nums[end];
            }
            sum = Math.max(sum, localSum);
            set.remove(nums[start]);
            localSum -= nums[start];
            start++;
        }
        return sum;
    }

    public static void main(String args[]) {
        MaximumErasureValue mev = new MaximumErasureValue();
        int[] nums = new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5};
        System.out.println(mev.maximumUniqueSubarray(nums));
    }
}
