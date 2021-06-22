
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ans = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                int local = 0;
                while (set.contains(num)) {
                    local++;
                    num++;
                }
                ans = Math.max(local, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums));
    }
}
