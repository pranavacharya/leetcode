
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        backtrack(result, new ArrayList(), nums, 0, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, ArrayList<Integer> path, int[] nums, int index, int target) {
        if (path.size() == 3) {
            if (target == 0 && !result.contains(path)) {
                result.add(new ArrayList(path));
            }
        } else {
            for (int i = index; i < nums.length; i++) {
                if (i != index && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] <= target) {
                    path.add(nums[i]);
                    backtrack(result, path, nums, i + 1, target - nums[i]);
                    path.remove(path.size() - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] input = {-1, 0, 1, 2, -1, -4};
//        int[] input = {-4, -8, 7, 13, 10, 1, -14, -13, 0, 8, 6, -13, -5, -4, -12, 2, -11, 7, -5, 0, -9, -14, -8, -9, 2, -7, -13, -3, 13, 9, -14, -6, 8, 1, 14, -5, -13, 8, -10, -5, 1, 11, -11, 3, 14, -8, -10, -12, 6, -8, -5, 13, -15, 2, 11, -5, 10, 6, -1, 1, 0, 0, 2, -7, 8, -6, 3, 3, -13, 8, 5, -5, -3, 9, 5, -4, -14, 11, -8, 7, 10, -6, -3, 11, 12, -14, -9, -1, 7, 5, -15, 14, 12, -5, -8, -2, 4, 2, -14, -2, -12, 6, 8, 0, 0, -2, 3, -7, -14, 2, 7, 12, 12, 12, 0, 9, 13, -2, -15, -3, 10, -14, -4, 7, -12, 3, -10};
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(input));
    }
}
