
import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = recursion(new ArrayList(), nums, 0, new ArrayList());
        return result;
    }

    public ArrayList recursion(ArrayList soFar, int[] nums, int index, ArrayList result) {
        if (index == nums.length) {
            result.add(soFar);
        } else {
            ArrayList left = new ArrayList(soFar);
            left.add(nums[index]);
            ArrayList right = new ArrayList(soFar);
            recursion(left, nums, index + 1, result);
            recursion(right, nums, index + 1, result);
        }
        return result;
    }

    public static void main(String args[]) {
        Subsets s = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(s.subsets(nums));
    }
}
