
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        helper(result, nums, new ArrayList(), 0);
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, List<Integer> path, int index) {
        if (index == nums.length) {
            if (!result.contains(path)) {
                result.add(new ArrayList(path));
            }
            return;
        }
        helper(result, nums, path, index + 1);
        path.add(nums[index]);
        helper(result, nums, path, index + 1);
        path.remove(path.size() - 1);
    }

    public static void main(String args[]) {
        Subsets2 s2 = new Subsets2();
//        int[] nums = new int[]{4, 4, 4, 1, 4};
        int[] nums = new int[]{1, 2, 2};
        System.out.println(s2.subsetsWithDup(nums));
    }
}
