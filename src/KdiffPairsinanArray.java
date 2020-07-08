
import java.util.Arrays;
import java.util.HashSet;

public class KdiffPairsinanArray {

    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet();
        HashSet<String> visited = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - k) && !visited.contains("" + nums[i] + "," + (nums[i] - k))) {
                count++;
                visited.add("" + nums[i] + "," + (nums[i] - k));
            }
            set.add(nums[i]);
        }
        return count;
    }

    public static void main(String args[]) {
        KdiffPairsinanArray kdpia = new KdiffPairsinanArray();
        int[] nums = new int[]{3, 1, 4, 1, 5};
        System.out.println(kdpia.findPairs(nums, 2));
    }
}
