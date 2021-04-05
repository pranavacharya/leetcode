
public class CountNicePairsinanArray {

    private int mod = (int) (1e9 + 7);

    public int countNicePairs(int[] nums) {
        int[] cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cache[i] = calRev(nums[i]);
        }
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + cache[j] == nums[j] + cache[i]) {
                    count = (count % mod + 1 % mod) % mod;
                }
            }
        }

        return count;
    }

    private int calRev(int n) {
        int ans = 0;

        while (n > 0) {
            int digit = n % 10;
            ans = ans * 10 + digit;
            n /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        CountNicePairsinanArray cnpia = new CountNicePairsinanArray();
        int[] nums = new int[]{42, 11, 1, 97};
        System.out.println(cnpia.countNicePairs(nums));
    }
}
