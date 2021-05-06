
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    for (int l = k + 1; l < nums.length; l++) {
                        if (l != k + 1 && nums[l] == nums[l - 1]) {
                            continue;
                        }
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> temp = new ArrayList();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            result.add(temp);
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(fs.fourSum(nums, 8));
    }
}
