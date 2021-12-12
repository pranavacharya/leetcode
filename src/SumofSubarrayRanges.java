
public class SumofSubarrayRanges {

    long[][] dp;

    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += (max - min);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SumofSubarrayRanges ss = new SumofSubarrayRanges();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(ss.subArrayRanges(nums));
    }
}
