
public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        boolean[] prime = new boolean[n];
        for (int i = 0; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i; j * i < prime.length; j++) {
                    prime[i * j] = false;
                }
            }
        }

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(499979));
    }
}
