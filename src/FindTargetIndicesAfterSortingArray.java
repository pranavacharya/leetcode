
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindTargetIndicesAfterSortingArray ftiasa = new FindTargetIndicesAfterSortingArray();
        int[] nums = new int[]{1, 2, 5, 2, 3};
        System.out.println(ftiasa.targetIndices(nums, 2));
    }
}
