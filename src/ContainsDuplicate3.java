
public class ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(1L * nums[i] - nums[j]) <= t && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ContainsDuplicate3 cd = new ContainsDuplicate3();
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(cd.containsNearbyAlmostDuplicate(nums, 3, 0));
    }
}
