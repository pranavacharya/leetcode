
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        while (n > 0 && n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

    public static void main(String args[]) {
        PowerOfTwo pot = new PowerOfTwo();
        System.out.println(pot.isPowerOfTwo(128));
    }
}
