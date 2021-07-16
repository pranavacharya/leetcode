
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        helper(result, nums, 0, target, 4, new ArrayList());
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, int index, int target, int k, List<Integer> path) {
        if (target == 0 && k == 0) {
            if (!result.contains(path)) {
                result.add(new ArrayList(path));
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(result, nums, i + 1, target - nums[i], k - 1, path);
            path.remove(path.size() - 1);
            helper(result, nums, i + 1, target, k, path);
        }
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fs.fourSum(nums, 0));
    }
}
