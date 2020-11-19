
import java.util.Arrays;

public class PrimeArrangements {

    private int mod = (int) 1e9 + 7;

    public int numPrimeArrangements(int n) {
        int count = primeNumbers(n);
        long primes = factorial(count);
        long composite = factorial(n - count);
        return (int) ((primes % mod * composite % mod) % mod);
    }

    private int primeNumbers(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < isPrime.length; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = 2; i * j < isPrime.length; j++) {
                isPrime[i * j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    private long factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = (ans % mod * i % mod) % mod;
        }

        return ans;
    }

    public static void main(String args[]) {
        PrimeArrangements pa = new PrimeArrangements();
        System.out.println(pa.numPrimeArrangements(5));
        System.out.println(pa.numPrimeArrangements(10));
        System.out.println(pa.numPrimeArrangements(15));
        System.out.println(pa.numPrimeArrangements(100));
    }
}
