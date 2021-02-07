
import java.util.HashMap;
import java.util.HashSet;

public class ClosestSubsequenceSum {

    private long minDiff;
    private HashMap<Integer, HashSet<Long>> visited;

    public int minAbsDifference(int[] nums, int goal) {
        this.minDiff = Integer.MAX_VALUE;
        this.visited = new HashMap();
        for (int i = 0; i <= nums.length; i++) {
            this.visited.put(i, new HashSet());
        }
        backtracking(nums, 0, goal, 0);
        return (int) this.minDiff;
    }

    private void backtracking(int[] nums, int index, long goal, long sum) {
        if (index == nums.length) {
            this.minDiff = Math.min(this.minDiff, Math.abs(sum - goal));
            return;
        }
        HashSet<Long> set = this.visited.get(index + 1);
        if (!set.contains(sum + nums[index])) {
            backtracking(nums, index + 1, goal, sum + nums[index]);
            set.add(sum + nums[index]);
        }
        if (!set.contains(sum)) {
            backtracking(nums, index + 1, goal, sum);
            set.add(sum);
        }
    }

    public static void main(String args[]) {
        ClosestSubsequenceSum css = new ClosestSubsequenceSum();
        int[] nums = new int[]{-6670649, 8310918, -1083608, -6411770, -3143329, -1218887, -7759463, 9166839, 7662295, -7366086, -7556854, -2705914, -4182761, 7162294, 4498528, -9266857, 9809165, 2351547, 6330034, -478850};
        System.out.println(css.minAbsDifference(nums, 558683375));
    }
}
