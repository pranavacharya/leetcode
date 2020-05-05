
import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        boolean[] used = new boolean[nums.length];
        permutation(result, new ArrayList(), used, nums, 0);
        return result;
    }

    public void permutation(List<List<Integer>> result, ArrayList<Integer> path, boolean used[], int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList(path));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                permutation(result, path, used, nums, index + 1);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String args[]) {
        Permutations p = new Permutations();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(p.permute(nums));
    }
}
