
public class SumofFlooredPairs {

    private int mod = (int) 1e9 + 7;
    private int max = (int) 1e5;

    public int sumOfFlooredPairs(int[] nums) {
        int[] freq = new int[max + 1];
        int[] prefixFreq = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            prefixFreq[i] = freq[i] + prefixFreq[i - 1];
        }

        long ans = 0;
        for (int i = 1; i <= max; i++) {
            if (prefixFreq[i] > prefixFreq[i - 1]) {
                long sum = 0;
                for (int j = 1; i * j <= max; ++j) {
                    int lower = i * j - 1;
                    int upper = i * (j + 1) - 1;
                    sum += (prefixFreq[Math.min(upper, max)] - prefixFreq[lower]) * (long) j;
                }
                ans = (ans + (sum % mod) * (prefixFreq[i] - prefixFreq[i - 1])) % mod;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        SumofFlooredPairs sfp = new SumofFlooredPairs();
        int[] nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(sfp.sumOfFlooredPairs(nums));
    }
}
