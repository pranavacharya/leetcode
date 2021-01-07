
public class PartitiontoKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return helper(nums, 0, sum / k, visited, 0, k);
    }

    private boolean helper(int[] nums, int sum, int target, boolean[] visited, int index, int partitions) {
        if (partitions == 0) {
            return true;
        }
        if (sum == target && helper(nums, 0, target, visited, 0, partitions - 1)) {
            return true;
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited[i] && nums[i] + sum <= target) {
                visited[i] = true;
                if (helper(nums, sum + nums[i], target, visited, i + 1, partitions)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        PartitiontoKEqualSumSubsets pkqs = new PartitiontoKEqualSumSubsets();
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        System.out.println(pkqs.canPartitionKSubsets(nums, 4));
    }
}
