
public class MaximumDifferenceBetweenIncreasingElements {

    public int maximumDifference(int[] nums) {
        int ans = -1;
        int small = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (small >= nums[i]) {
                small = nums[i];
            } else {
                ans = Math.max(ans, nums[i] - small);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumDifferenceBetweenIncreasingElements mdbie = new MaximumDifferenceBetweenIncreasingElements();
        int[] nums = new int[]{7, 1, 5, 4};
        System.out.println(mdbie.maximumDifference(nums));
    }

}
