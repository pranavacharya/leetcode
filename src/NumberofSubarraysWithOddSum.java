
public class NumberofSubarraysWithOddSum {

    private long mod = 1000000007;

    public int numOfSubarrays(int[] arr) {
        int[] suffix = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            suffix[i] = sum;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int local = 0;
                if (i == 0) {
                    local = suffix[j] - 0;
                } else {
                    local = suffix[j] - suffix[i - 1];
                }
                if (local % 2 != 0) {
                    ans = (int) (((ans % mod) + 1) % mod);
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        NumberofSubarraysWithOddSum nswos = new NumberofSubarraysWithOddSum();
        int[] arr = new int[]{1, 3, 5};
        System.out.println(nswos.numOfSubarrays(arr));
    }
}
