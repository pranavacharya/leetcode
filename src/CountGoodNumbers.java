
public class CountGoodNumbers {

    private int mod = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        // n = 4
        // even -> 0, 2, 4, 6, 8
        // prime -> 2, 3, 5, 7
        // even odd even odd
        // 5 * 4 * 5 * 4 = 20 * 20 = 400
        long ans = 1;
        long times = n / 2;
        long base = 20;
        while (times > 0) {
            if (times % 2 == 1) {
                ans = ((ans % mod) * (base % mod)) % mod;
            }
            times = times / 2;
            base = ((base % mod) * (base % mod)) % mod;
        }
        if (n % 2 == 1) {
            ans = ((ans % mod) * 5) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        CountGoodNumbers cgn = new CountGoodNumbers();
        System.out.println(cgn.countGoodNumbers(4));
    }
}
