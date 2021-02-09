
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ClosestSubsequenceSum {

    public static int minAbsDifference(int[] nums, int goal) {
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        generate(0, nums.length / 2, nums, 0, leftSet);
        generate(nums.length / 2, nums.length, nums, 0, rightSet);
        TreeSet<Integer> ts = new TreeSet<>(rightSet);
        int ans = Math.abs(goal);
        for (int left : leftSet) {
            int right = goal - left;
            if (ts.contains(right)) {
                return 0;
            }
            Integer right1 = ts.lower(right);
            Integer right2 = ts.higher(right);
            if (right1 != null) {
                ans = Math.min(ans, Math.abs(left + right1 - goal));
            }
            if (right2 != null) {
                ans = Math.min(ans, Math.abs(left + right2 - goal));
            }
        }
        return ans;
    }

    private static void generate(int pos, int stop, int[] nums, int sum, Set<Integer> set) {
        if (pos == stop) {
            set.add(sum);
            return;
        }
        generate(pos + 1, stop, nums, sum, set);
        generate(pos + 1, stop, nums, sum + nums[pos], set);
    }

    public static void main(String args[]) {
        ClosestSubsequenceSum css = new ClosestSubsequenceSum();
        int[] nums = new int[]{-6670649, 8310918, -1083608, -6411770, -3143329, -1218887, -7759463, 9166839, 7662295, -7366086, -7556854, -2705914, -4182761, 7162294, 4498528, -9266857, 9809165, 2351547, 6330034, -478850};
        System.out.println(css.minAbsDifference(nums, 558683375));
    }
}
