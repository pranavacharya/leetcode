
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && nums[i] > nums[j]) {
                    return true;
                }
                if (nums[i] > nums[j]) {
                    dp[i] = true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(its.increasingTriplet(nums));
    }
}
