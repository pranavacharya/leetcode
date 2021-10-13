
import java.util.Arrays;

public class NthTribonacciNumber {

    int[] memo;

    public int tribonacci(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, -1);
        return helper(n);
    }

    private int helper(int n) {
        if (this.memo[n] != -1) {
            return this.memo[n];
        }

        if (n <= 1) {
            return n;
        } else if (n == 2) {
            return 1;
        } else {
            return this.memo[n] = (helper(n - 1) + helper(n - 2) + helper(n - 3));
        }
    }

    public static void main(String args[]) {
        NthTribonacciNumber ntn = new NthTribonacciNumber();
        System.out.println(ntn.tribonacci(25));
    }
}
