
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList(), result);
        return result;
    }

    public void subsets(int[] nums, int index, ArrayList path, List<List<Integer>> result) {
        result.add(new ArrayList(path));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            subsets(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String args[]) {
        Subsets2 s2 = new Subsets2();
//        int[] nums = new int[]{4, 4, 4, 1, 4};
        int[] nums = new int[]{1, 2, 2};
        System.out.println(s2.subsetsWithDup(nums));
    }
}
