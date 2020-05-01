
import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permulations(nums, result, 0, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    public void permulations(int[] nums, List<List<Integer>> result, int index, ArrayList<Integer> path, boolean[] used) {
        if (path.size() == nums.length && !result.contains(path)) {
            result.add(new ArrayList(path));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                permulations(nums, result, index + 1, path, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        Permutations2 p2 = new Permutations2();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(p2.permuteUnique(nums));
    }
}
