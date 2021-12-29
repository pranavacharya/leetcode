
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] + first == 0) {
                    List<Integer> temp = new ArrayList();
                    temp.add(first);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    // if(!result.contains(temp))
                    result.add(temp);
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                } else if (nums[j] + nums[k] + first > 0) {
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                } else {
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] input = {-1, 0, 1, 2, -1, -4};
//        int[] input = {-4, -8, 7, 13, 10, 1, -14, -13, 0, 8, 6, -13, -5, -4, -12, 2, -11, 7, -5, 0, -9, -14, -8, -9, 2, -7, -13, -3, 13, 9, -14, -6, 8, 1, 14, -5, -13, 8, -10, -5, 1, 11, -11, 3, 14, -8, -10, -12, 6, -8, -5, 13, -15, 2, 11, -5, 10, 6, -1, 1, 0, 0, 2, -7, 8, -6, 3, 3, -13, 8, 5, -5, -3, 9, 5, -4, -14, 11, -8, 7, 10, -6, -3, 11, 12, -14, -9, -1, 7, 5, -15, 14, 12, -5, -8, -2, 4, 2, -14, -2, -12, 6, 8, 0, 0, -2, 3, -7, -14, 2, 7, 12, 12, 12, 0, 9, 13, -2, -15, -3, 10, -14, -4, 7, -12, 3, -10};
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(input));
    }
}
