
public class ConcatenationofConsecutiveBinaryNumbers {

    private long mod = (long) (1e9 + 7);

    public int concatenatedBinary(int n) {
        long ans = 0;
        int index = 0;
        while (n > 0) {
            int i = 0;
            while (n >= (1 << i)) {
                if ((n & (1 << i)) == (1 << i)) {
                    ans = (ans % mod + power(2, index) % mod) % mod;
                }
                index++;
                i++;
            }
            n--;
        }
        return (int) ans;
    }

    private long power(long x, long n) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result = result * x % mod;
            }
            n = n / 2;
            x = x * x % mod;
        }
        return result;
    }

    public static void main(String args[]) {
        ConcatenationofConsecutiveBinaryNumbers ccbn = new ConcatenationofConsecutiveBinaryNumbers();
        System.out.println(ccbn.concatenatedBinary(12));
    }
}
