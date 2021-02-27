
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        long ans = 0;
        int sign = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? 1 : -1;
        long dv = Math.abs((long) dividend);
        long ds = Math.abs((long) divisor);
        while (dv >= ds) {
            dv -= ds;
            ans++;
        }
        return (int) Math.min(Integer.MAX_VALUE, (sign * ans));
    }

    public static void main(String[] args) {
        DivideTwoIntegers dti = new DivideTwoIntegers();
        System.out.println(dti.divide(10, 3));
    }
}
