
import java.util.HashMap;

public class PartitionEqualSubsetSum {

    private HashMap<String, Boolean> map = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % 2 != 0) {
            return false;
        }
        return subset(nums, 0, 0, total);
    }

    public boolean subset(int[] nums, int index, int sum, int total) {
        String state = index + "-" + sum;
        if (this.map.containsKey(state)) {
            return this.map.get(state);
        }
        if (sum == total / 2) {
            return true;
        }
        if (sum > total / 2 || index >= nums.length) {
            return false;
        }
        boolean status = subset(nums, index + 1, sum, total) || subset(nums, index + 1, sum + nums[index], total);
        this.map.put(state, status);
        return status;
    }

    public static void main(String args[]) {
        PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
        int[] nums = new int[]{1, 5, 11, 5};
//        int[] nums = new int[]{100, 100, 100, 100, 100, 100, 100, 100};
//        int[] nums = new int[]{28, 63, 95, 30, 39, 16, 36, 44, 37, 100, 61, 73, 32, 71, 100, 2, 37, 60, 23, 71, 53, 70, 69, 82, 97, 43, 16, 33, 29, 5, 97, 32, 29, 78, 93, 59, 37, 88, 89, 79, 75, 9, 74, 32, 81, 12, 34, 13, 16, 15, 16, 40, 90, 70, 17, 78, 54, 81, 18, 92, 75, 74, 59, 18, 66, 62, 55, 19, 2, 67, 30, 25, 64, 84, 25, 76, 98, 59, 74, 87, 5, 93, 97, 68, 20, 58, 55, 73, 74, 97, 49, 71, 42, 26, 8, 87, 99, 1, 16, 79};
        System.out.println(pess.canPartition(nums));
    }
}
