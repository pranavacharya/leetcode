
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence lcis = new LongestContinuousIncreasingSubsequence();
        int[] arr = new int[]{1, 3, 5, 4, 2, 3, 4, 5};
        System.out.println(lcis.findLengthOfLCIS(arr));
    }
}
