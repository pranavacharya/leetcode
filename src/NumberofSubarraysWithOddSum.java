
public class NumberofSubarraysWithOddSum {

    private long mod = 1000000007;

    public int numOfSubarrays(int[] arr) {
        int evenSum = 1;
        int oddSum = 0;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                ans = (int) (((ans % mod) + (oddSum % mod)) % mod);
                evenSum++;
            } else {
                ans = (int) (((ans % mod) + (evenSum % mod)) % mod);
                oddSum++;
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
