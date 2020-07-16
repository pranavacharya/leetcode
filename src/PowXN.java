
public class PowXN {

    public double myPow(double x, int n) {
        double ans = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            ans *= x;
        }
        return n < 0 ? 1 / ans : ans;
    }

    public static void main(String args[]) {
        PowXN p = new PowXN();
        System.out.println(p.myPow(2, -2));
    }
}
