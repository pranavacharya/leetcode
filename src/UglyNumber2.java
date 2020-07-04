
public class UglyNumber2 {

    public int nthUglyNumber(int n) {
        int count = 1;
        int i = 1;
        while (count <= n && count <= 1690) {
            if (isUgly(i)) {
                count++;
            }
            i++;
        }
        return i - 1;
    }

    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        while (n != 0 && n % 2 == 0) {
            n /= 2;
        }
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        while (n != 0 && n % 5 == 0) {
            n /= 5;
        }
        return 1 == n;
    }

    public static void main(String args[]) {
        UglyNumber2 ug = new UglyNumber2();
        System.out.println(ug.nthUglyNumber(20));
    }
}
