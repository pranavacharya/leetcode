
import java.util.ArrayList;

public class UglyNumber2 {

    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        ArrayList<Integer> ugly = new ArrayList();
        ugly.add(1);
        while (ugly.size() < n) {
            int fac2 = 2 * ugly.get(index2);
            int fac3 = 3 * ugly.get(index3);
            int fac5 = 5 * ugly.get(index5);
            int min = Math.min(fac2, Math.min(fac3, fac5));
            ugly.add(min);
            if (min == fac2) {
                index2++;
            }
            if (min == fac3) {
                index3++;
            }
            if (min == fac5) {
                index5++;
            }
        }
        return ugly.get(ugly.size() - 1);
    }

    public static void main(String args[]) {
        UglyNumber2 ug = new UglyNumber2();
        System.out.println(ug.nthUglyNumber(20));
    }
}
