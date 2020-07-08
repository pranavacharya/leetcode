
import java.util.Arrays;

public class KdiffPairsinanArray {

    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (i == j) {
                j++;
            } else if (nums[j] - nums[i] == k) {
                count++;
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
                j++;
            } else if (nums[j] - nums[i] < k) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        KdiffPairsinanArray kdpia = new KdiffPairsinanArray();
        int[] nums = new int[]{1, 1, 1, 2, 2};
//        int[] nums = new int[]{3, 1, 4, 1, 5};
        System.out.println(kdpia.findPairs(nums, 1));
    }
}
