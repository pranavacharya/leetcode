
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            result.addAll(threeSum(nums, i + 1, target - nums[i], nums[i]));
        }
        return result;
    }

    private List<List<Integer>> threeSum(int[] nums, int index, int target, int first) {
        List<List<Integer>> list = new ArrayList();
        for (int k = index; k < nums.length - 2; k++) {
            if (k != index && nums[k] == nums[k - 1]) {
                continue;
            }
            int newTarget = target - nums[k];
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == newTarget) {
                    List<Integer> temp = new ArrayList();
                    temp.add(first);
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    list.add(temp);
                    do {
                        i++;
                    } while (i < nums.length && nums[i] == nums[i - 1]);
                    do {
                        j--;
                    } while (j >= 0 && nums[j] == nums[j + 1]);
                } else if (nums[i] + nums[j] < newTarget) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fs.fourSum(nums, 0));
    }
}
