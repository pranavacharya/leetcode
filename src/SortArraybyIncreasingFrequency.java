
import java.util.Arrays;
import java.util.HashMap;

public class SortArraybyIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        int[] ans = new int[nums.length];
        int index = 0;
        while (!freq.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int val = -1;
            for (int key : freq.keySet()) {
                if (freq.get(key) < min) {
                    val = key;
                    min = freq.get(key);
                }
                if (freq.get(key) == min && key > val) {
                    val = key;
                    min = freq.get(key);
                }
            }
            int end = index + min;
            for (int i = index; i < end; i++, index++) {
                ans[i] = val;
            }
            freq.remove(val);
        }
        return ans;
    }

    public static void main(String args[]) {
        SortArraybyIncreasingFrequency adif = new SortArraybyIncreasingFrequency();
        int[] nums = new int[]{1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(adif.frequencySort(nums)));
    }
}
