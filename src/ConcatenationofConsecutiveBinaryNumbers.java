
public class ConcatenationofConsecutiveBinaryNumbers {

    private long mod = (long) (1e9 + 7);

    public int concatenatedBinary(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = (sum * (int) Math.pow(2, Integer.toBinaryString(i).length()) + i) % mod;
        }
        return (int) sum;
    }

    public static void main(String args[]) {
        ConcatenationofConsecutiveBinaryNumbers ccbn = new ConcatenationofConsecutiveBinaryNumbers();
        System.out.println(ccbn.concatenatedBinary(12));
        System.out.println(ccbn.concatenatedBinary(5318411));
    }
}
