
public class SumofFlooredPairs {

    private int mod = (int) 1e9 + 7;

    public int sumOfFlooredPairs(int[] nums) {
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j >= 0; j--) {
                ans = (ans % mod + (nums[i] / nums[j]) % mod) % mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SumofFlooredPairs sfp = new SumofFlooredPairs();
        int[] nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(sfp.sumOfFlooredPairs(nums));
    }
}
