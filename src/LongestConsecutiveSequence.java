
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int item : set) {
            int local = 1;
            while (set.contains(item + 1)) {
                item++;
                local++;
            }
            max = Math.max(max, local);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums));
    }
}
