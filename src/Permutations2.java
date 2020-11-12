
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        permute(result, nums, new ArrayList(), new boolean[nums.length]);
        return result;
    }

    private void permute(List<List<Integer>> result, int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            permute(result, nums, path, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String args[]) {
        Permutations2 p2 = new Permutations2();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(p2.permuteUnique(nums));
    }
}
