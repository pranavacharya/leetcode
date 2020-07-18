
public class PowerofThree {

    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            } else {
                n /= 3;
            }
        }
        return n == 1;
    }

    public static void main(String args[]) {
        PowerofThree pot = new PowerofThree();
        System.out.println(pot.isPowerOfThree(18));
    }
}
