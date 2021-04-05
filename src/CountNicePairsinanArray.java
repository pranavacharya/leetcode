
import java.util.HashMap;

public class CountNicePairsinanArray {

    private int mod = (int) (1e9 + 7);

    public int countNicePairs(int[] nums) {
        int[] cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cache[i] = nums[i] - calRev(nums[i]);
        }
        int count = 0;
        HashMap<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(cache[i])) {
                int freqcount = freq.get(cache[i]);

                count = ((count % mod) + (freqcount % mod)) % mod;
            }
            freq.put(cache[i], freq.getOrDefault(cache[i], 0) + 1);
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
