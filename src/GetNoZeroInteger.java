
import java.util.Arrays;

public class GetNoZeroInteger {

    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n - a;
        while (isZeroPresent(a) || isZeroPresent(b)) {
            a++;
            b = n - a;
        }
        return new int[]{a, b};
    }

    public boolean isZeroPresent(int i) {
        while (i > 0) {
            if (i % 10 == 0) {
                return true;
            } else {
                i = i / 10;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        GetNoZeroInteger gnzi = new GetNoZeroInteger();
        System.out.println(Arrays.toString(gnzi.getNoZeroIntegers(1010)));
    }
}
