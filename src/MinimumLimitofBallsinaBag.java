
public class MinimumLimitofBallsinaBag {

    public int minimumSize(int[] nums, int maxOperations) {
        int low = 0;
        int high = (int) 1e9;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSatisfy(nums, maxOperations, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canSatisfy(int[] nums, int maxOps, int mid) {
        if (mid == 0) {
            return false;
        }
        int opsNeeded = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= mid) {
                continue;
            }
            opsNeeded += calculateDivs(nums[i], mid);
        }
        return opsNeeded <= maxOps;
    }

    private int calculateDivs(int n, int part) {
        int count = n / part;
        return n % part == 0 ? count - 1 : count;
    }

    public static void main(String args[]) {
        MinimumLimitofBallsinaBag mlobib = new MinimumLimitofBallsinaBag();
        int[] nums = new int[]{1};
        System.out.println(mlobib.minimumSize(nums, 1));
    }
}
