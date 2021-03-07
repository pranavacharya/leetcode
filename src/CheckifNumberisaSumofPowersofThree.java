
import java.util.HashSet;

public class CheckifNumberisaSumofPowersofThree {

    public boolean checkPowersOfThree(int n) {
        HashSet<Integer> set = new HashSet();
        while (n > 0) {
            int power = findMaxPower(n);
            if (!set.add(power)) {
                return false;
            }
            n = (int) (n - Math.pow(3, power));
        }
        return n == 0;
    }

    private int findMaxPower(int n) {
        int power = 0;
        while (Math.pow(3, power) <= n) {
            power++;
        }
        return power - 1;
    }

    public static void main(String[] args) {
        CheckifNumberisaSumofPowersofThree cinpt = new CheckifNumberisaSumofPowersofThree();
        System.out.println(cinpt.checkPowersOfThree(91));
        System.out.println(cinpt.checkPowersOfThree(12));
        System.out.println(cinpt.checkPowersOfThree(21));
    }
}
