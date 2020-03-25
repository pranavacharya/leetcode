
import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        while (!visited.contains(n)) {
            visited.add(n);
            if (n == 1) {
                return true;
            }
            n = squareOfDigit(n);
        }
        return false;
    }

    public int squareOfDigit(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String args[]) {
        HappyNumber hp = new HappyNumber();
        System.out.println(hp.isHappy(1));
    }
}
