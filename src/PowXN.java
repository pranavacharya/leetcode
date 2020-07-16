
public class PowXN {

    public double myPow(double x, int n) {
        return myPow(x, 1L * n);
    }

    public double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return myPow(1 / x, -n);
        } else {
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            } else {
                return x * myPow(x * x, n / 2);
            }
        }
    }

    public static void main(String args[]) {
        PowXN p = new PowXN();
        System.out.println(p.myPow(2, 10));
    }
}
