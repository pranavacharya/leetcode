
import java.util.HashMap;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.containsKey(nums[i] + 1)) {
                int complement = freq.get(nums[i] + 1);
                int curr = freq.get(nums[i]);
                max = Math.max(max, complement + curr);
            }
            if (freq.containsKey(nums[i] - 1)) {
                int complement = freq.get(nums[i] - 1);
                int curr = freq.get(nums[i]);
                max = Math.max(max, complement + curr);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestHarmoniousSubsequence lhs = new LongestHarmoniousSubsequence();
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(lhs.findLHS(nums));
    }
}
