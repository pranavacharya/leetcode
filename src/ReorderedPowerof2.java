
import java.util.Arrays;

public class ReorderedPowerof2 {

    public boolean reorderedPowerOf2(int N) {
        int[] NCount = countDigitFreq(N);
        for (int i = 0, mask = 1; i < 31; i++, mask <<= 1) {
            if (Arrays.equals(NCount, countDigitFreq(mask))) {
                return true;
            }
        }
        return false;
    }

    private int[] countDigitFreq(int n) {
        int[] ans = new int[10];
        while (n > 0) {
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReorderedPowerof2 rp2 = new ReorderedPowerof2();
        System.out.println(rp2.reorderedPowerOf2(16));
        System.out.println(rp2.reorderedPowerOf2(10));
        System.out.println(rp2.reorderedPowerOf2(46));
    }
}
