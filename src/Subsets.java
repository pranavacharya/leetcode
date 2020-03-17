
import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        recursion(new ArrayList(), nums, 0);
        return this.result;
    }

    public void recursion(ArrayList soFar, int[] nums, int index) {
        if (index == nums.length) {
            this.result.add(soFar);
        } else {
            ArrayList left = new ArrayList(soFar);
            left.add(nums[index]);
            ArrayList right = new ArrayList(soFar);
            recursion(left, nums, index + 1);
            recursion(right, nums, index + 1);
        }
    }

    public static void main(String args[]) {
        Subsets s = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(s.subsets(nums));
    }
}
