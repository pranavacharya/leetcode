
public class SumofDigitsinBaseK {

    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }

    public static void main(String[] args) {
        SumofDigitsinBaseK sdib = new SumofDigitsinBaseK();
        System.out.println(sdib.sumBase(34, 6));
    }
}
