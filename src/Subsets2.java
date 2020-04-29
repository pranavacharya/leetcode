
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        subsets(nums, 0, new ArrayList(), result);
        return result;
    }

    public void subsets(int[] nums, int index, ArrayList path, List<List<Integer>> result) {
        if (index == nums.length) {
            ArrayList temp = new ArrayList(path);
            Collections.sort(temp);
            if (!result.contains(temp)) {
                result.add(temp);
            }
        } else {
            for (int i = index; i < nums.length; i++) {
                path.add(nums[i]);
                subsets(nums, i + 1, path, result);
                path.remove(path.size() - 1);
                subsets(nums, i + 1, path, result);
            }
        }
    }

    public static void main(String args[]) {
        Subsets2 s2 = new Subsets2();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(s2.subsetsWithDup(nums));
    }
}
