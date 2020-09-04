
import java.util.Collections;
import java.util.HashMap;

public class DegreeofanArray {

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap();
        HashMap<Integer, Integer> first = new HashMap();
        HashMap<Integer, Integer> last = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            last.put(nums[i], i);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        int max = Collections.max(freq.values());
        int res = Integer.MAX_VALUE;
        for (int i : freq.keySet()) {
            if (freq.get(i) == max) {
                res = Math.min(res, last.get(i) - first.get(i) + 1);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        DegreeofanArray da = new DegreeofanArray();
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(da.findShortestSubArray(nums));
    }
}
